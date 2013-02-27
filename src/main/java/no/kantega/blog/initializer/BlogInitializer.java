package no.kantega.blog.initializer;

import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.filter.CharEncodingFilter;
import org.apache.derby.jdbc.EmbeddedConnectionPoolDataSource;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import static no.kantega.blog.services.Services.addService;
import static no.kantega.blog.services.Services.getService;

/**
 *
 */
public class BlogInitializer implements ServletContainerInitializer{

    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        Logger.getLogger(getClass().getName()).info("Starting up");

        addService(DataSource.class, initializeDatasource(), servletContext);

        addService(BlogDao.class, new BlogDao(getService(DataSource.class, servletContext)), servletContext);

        configureCharEncFilter(servletContext);
    }

    private void configureCharEncFilter(ServletContext servletContext) {
        EnumSet<DispatcherType> enums = EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST, DispatcherType.FORWARD);
        servletContext.addFilter("charEncoding", CharEncodingFilter.class).addMappingForUrlPatterns(enums, false, "*.jsp");
    }

    private DataSource initializeDatasource() throws ServletException {

        System.setProperty("derby.stream.error.file", "target/derby.log");
        EmbeddedConnectionPoolDataSource dataSource = new EmbeddedConnectionPoolDataSource();

        dataSource.setCreateDatabase("create");

        dataSource.setDatabaseName("target/blogdb");


        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            List<String> statements = Arrays.asList(
                    "create table blog (blogid  integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                            " blogname varchar(255), " +
                            " color varchar(7) )",

                    "create table blogpost (blogpostid  integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                            " blogid integer NOT NULL,  " +
                            " posttitle varchar(255) NOT NULL, " +
                            " postcontent clob (500K) NOT NULL, " +
                            " publishdate timestamp NOT NULL " +
                            " )",
                    "create table blogpostcomment (blogpostcommentid  integer NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)," +
                                                " blogpostid integer NOT NULL,  " +
                                                " commentauthor varchar(255) NOT NULL, " +
                                                " commentcontent clob (500K) NOT NULL, " +
                                                " commentpublishdate timestamp NOT NULL " +
                                                " )");


            for (String sql : statements) {
                statement.execute(sql);
            }

            statement.close();
            connection.close();


        } catch (SQLException e) {
            if(!"X0Y32".equals(e.getSQLState())) {
                throw new ServletException(e);
            }
        }
        return dataSource;
    }
}
