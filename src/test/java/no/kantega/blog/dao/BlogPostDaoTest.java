package no.kantega.blog.dao;

import java.util.List;
import javax.sql.DataSource;
import no.kantega.blog.db.DbStarter;
import no.kantega.blog.initializer.DBInitializer;
import no.kantega.blog.model.Blog;
import no.kantega.blog.model.BlogPost;
import org.apache.derby.drda.NetworkServerControl;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for blog post data access object.
 */
public class BlogPostDaoTest {
    
    private static NetworkServerControl server;
    private static DataSource ds;
    private Blog blog;
    private BlogPostDao dao;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        server = DbStarter.startDb(1531);
        ds = DBInitializer.initializeDatasource("jdbc:derby://localhost:1531/unittest_blogpostdao_db;create=true");
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        DbStarter.stopDb(server);
    }
    
    @Before
    public void setUp() throws Exception {
        dao = new BlogPostDao(ds);
        BlogDao blogDao = new BlogDao(ds);
        BlogDaoTest.emptyDb(ds);
        blog = new Blog();
        String blogName = "Unittest for blog posts";
        blog.setName(blogName);
        blog.setColor("#123456");
        blogDao.saveOrUpdate(blog);
        blog = blogDao.getBlogByName(blogName);
    }

    @Test
    public void testSave() {
        BlogPost post = new BlogPost(blog);
        post.setTitle("SomeTitle");
        post.setContent("SomeContent");
        assertTrue("New before save", post.isNew());
        dao.saveOrUpdate(post);
        BlogPost fromDb = dao.getBlogPost(blog, "SomeTitle");
        assertFalse("Not new after read from db", fromDb.isNew());
        assertEquals("Same title", post.getTitle(), fromDb.getTitle());
        assertEquals("Same content", post.getContent(), fromDb.getContent());
        assertEquals("Same blog", post.getBlog().getId(), fromDb.getBlog().getId());
    }

    @Test
    public void testUpdate() {
        BlogPost post = new BlogPost(blog);
        post.setTitle("SomeTitle");
        post.setContent("SomeContent");
        assertTrue("New before save", post.isNew());
        dao.saveOrUpdate(post);
        BlogPost fromDb = dao.getBlogPost(blog, "SomeTitle");
        fromDb.setTitle("New title");
        dao.saveOrUpdate(fromDb);
        BlogPost updated = dao.getBlogPost(fromDb.getBlogPostId());
        assertEquals("Same title", fromDb.getTitle(), updated.getTitle());
        assertEquals("Same content", fromDb.getContent(), updated.getContent());
        assertEquals("Same blog", fromDb.getBlog().getId(), updated.getBlog().getId());
    }

    @Test
    public void testGetBlogPosts() {
        List<BlogPost> posts = dao.getBlogPosts(blog);
        assertEquals("Should contain no posts", 0, posts.size());
        BlogPost post = new BlogPost(blog);
        post.setTitle("SomeTitle");
        post.setContent("SomeContent");
        assertTrue("New before save", post.isNew());
        dao.saveOrUpdate(post);
        List<BlogPost> postsAfter = dao.getBlogPosts(blog);
        assertEquals("Should contain a post after save", 1, postsAfter.size());
    }

}
