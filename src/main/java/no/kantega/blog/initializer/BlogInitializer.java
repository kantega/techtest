package no.kantega.blog.initializer;

import java.io.IOException;
import no.kantega.blog.filter.CharEncodingFilter;
import no.kantega.blog.filter.ErrorFilter;
import no.kantega.blog.listener.BlogSessionListener;
import no.kantega.blog.popularity.Stats;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.sql.DataSource;
import java.util.EnumSet;
import java.util.Set;
import java.util.logging.Logger;
import no.kantega.blog.dao.BlogDao;
import no.kantega.blog.dao.BlogPostCommentDao;
import no.kantega.blog.dao.BlogPostDao;

import static no.kantega.blog.services.Services.addService;
import static no.kantega.blog.services.Services.getService;

/**
 * Initializes the container.
 */
public class BlogInitializer implements ServletContainerInitializer {

    /**
     * Called when the container starts.
     * 
     * @param classes Classes loaded
     * @param servletContext Context we configure
     * @throws ServletException In case we fail to start
     */
    @Override
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {
        Logger.getLogger(getClass().getName()).info("Starting up");

        configureSessionListener(servletContext);
        try {
            addService(DataSource.class, DBInitializer.initializeDatasource("jdbc:derby://localhost:1527/blogdb;create=true"), servletContext);
        } catch (IOException ioex) {
            throw new ServletException("Failed initializing database", ioex);
        }
        addService(BlogDao.class, new BlogDao(getService(DataSource.class, servletContext)), servletContext);
        addService(BlogPostDao.class, new BlogPostDao(getService(DataSource.class, servletContext)), servletContext);
        addService(BlogPostCommentDao.class, new BlogPostCommentDao(getService(DataSource.class, servletContext)), servletContext);
        configureCharEncFilter(servletContext);
        configureErrorFilter(servletContext);
        configureStats(servletContext);
    }

    private void configureStats(ServletContext servletContext) {
        addService(Stats.class, new Stats(), servletContext);
    }

    private void configureErrorFilter(ServletContext servletContext) {
        EnumSet<DispatcherType> enums = EnumSet.of(DispatcherType.REQUEST);
        servletContext.addFilter("errorFilter", ErrorFilter.class).addMappingForUrlPatterns(enums, false, "/*");

    }

    private void configureSessionListener(ServletContext servletContext) throws ServletException {
        BlogSessionListener blogSessionListener = servletContext.createListener(BlogSessionListener.class);
        servletContext.addListener(blogSessionListener);
        addService(BlogSessionListener.class, blogSessionListener, servletContext);
    }

    private void configureCharEncFilter(ServletContext servletContext) {
        EnumSet<DispatcherType> enums = EnumSet.of(DispatcherType.INCLUDE, DispatcherType.REQUEST, DispatcherType.FORWARD);
        servletContext.addFilter("charEncoding", CharEncodingFilter.class).addMappingForUrlPatterns(enums, false, "*.jsp");
    }

}
