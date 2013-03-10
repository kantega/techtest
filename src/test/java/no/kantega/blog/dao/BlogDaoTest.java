package no.kantega.blog.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import no.kantega.blog.db.DbStarter;
import no.kantega.blog.initializer.DBInitializer;
import no.kantega.blog.model.Blog;
import org.apache.derby.drda.NetworkServerControl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Blog data access object.
 */
public class BlogDaoTest {
    
    private static NetworkServerControl server;
    private static DataSource ds;
    private BlogDao dao;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        server = DbStarter.startDb(1530);
        ds = DBInitializer.initializeDatasource("jdbc:derby://localhost:1530/unittest_blogdao_db;create=true");
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        DbStarter.stopDb(server);
    }
    
    @Before
    public void setUp() throws Exception {
        dao = new BlogDao(ds);
        emptyDb(ds);
    }

    public static void emptyDb(DataSource ds) throws SQLException {
        List<String> statements = Arrays.asList("TRUNCATE TABLE blogpostcomment",
                                                "TRUNCATE TABLE blogpost",
                                                "TRUNCATE TABLE blog");
        try (Connection conn = ds.getConnection()) {
            for (String statement : statements) {
                try (Statement stmt = conn.createStatement()) {
                    stmt.execute(statement);
                }
            }
        }
    }
    
    @Test
    public void testGetAllBlogs() throws Exception {
        Blog blog = new Blog();
        blog.setName("testblog");
        blog.setColor("#000");
        dao.saveOrUpdate(blog);
        List<Blog> blogs = dao.getAllBlogs();
        assertEquals("Only one blog now", 1, blogs.size());
        assertEquals("Correct blog", blog.getName(), blogs.get(0).getName());
        assertEquals("Correct blog", blog.getColor(), blogs.get(0).getColor());
        assertFalse("Should not be new", blogs.get(0).isNew());
    }

    @Test
    public void testSave() throws Exception {
        Blog blog = new Blog();
        blog.setName("testblog");
        blog.setColor("#fff");
        dao.saveOrUpdate(blog);
        Blog fromDb = dao.getBlogByName("testblog");
        assertEquals("Correct blog read", blog.getColor(), fromDb.getColor());
    }

    @Test
    public void testUpdate() throws Exception {
        Blog blog = new Blog();
        blog.setName("testblog");
        blog.setColor("#fff");
        dao.saveOrUpdate(blog);
        Blog fromDb = dao.getBlogByName("testblog");
        assertEquals("Correct blog read", blog.getColor(), fromDb.getColor());
        fromDb.setName("newname");
        fromDb.setColor("#eee");
        dao.saveOrUpdate(fromDb);
        Blog afterUpdate = dao.getBlogById(fromDb.getId());
        assertEquals("Color updated", fromDb.getColor(), afterUpdate.getColor());
        assertEquals("Name updated", fromDb.getName(), afterUpdate.getName());
    }

    @Test
    public void testDeleteBlogByName() throws Exception {
        Blog blog = new Blog();
        blog.setName("testblog");
        blog.setColor("#fff");
        dao.saveOrUpdate(blog);
        assertEquals("Only one blog", 1, dao.getAllBlogs().size());
        dao.deleteBlogByName("testblog");
        assertEquals("Blog was deleted", 0, dao.getAllBlogs().size());
    }
    
    @Test
    public void testDeleteBlogDoesntExist() throws Exception {
        try {
            dao.deleteBlogByName("nonexistingblog");
            fail("Should not be able to delete blog that doesn't exist");
        } catch (IllegalArgumentException iae) {
            assertTrue("Message should contain onformation, but was: " + iae.getMessage(), iae.getMessage().contains("nonexistingblog"));
        }
    }
    
    @Test
    public void testGetBlogDoesntExist() throws Exception {
        try {
            Blog blog = dao.getBlogById(1234l);
            fail("Should not be able to get blog by id that doesn't exist");
        } catch (IllegalArgumentException iae) {
            assertTrue("Message should contain onformation, but was: " + iae.getMessage(), iae.getMessage().contains("1234"));
        }
    }
    
}
