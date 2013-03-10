package no.kantega.blog.dao;

import java.util.List;
import javax.sql.DataSource;
import no.kantega.blog.db.DbStarter;
import no.kantega.blog.initializer.DBInitializer;
import no.kantega.blog.model.Blog;
import no.kantega.blog.model.BlogPost;
import no.kantega.blog.model.BlogPostComment;
import org.apache.derby.drda.NetworkServerControl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for comments data access object.
 */
public class BlogPostCommentDaoTest {
    
    private static NetworkServerControl server;
    private static DataSource ds;
    private Blog blog;
    private BlogPost post;
    private BlogPostCommentDao dao;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        server = DbStarter.startDb(1532);
        ds = DBInitializer.initializeDatasource("jdbc:derby://localhost:1532/unittest_blogpostcommentsdao_db;create=true");
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        DbStarter.stopDb(server);
    }
    
    @Before
    public void setUp() throws Exception {
        dao = new BlogPostCommentDao(ds);
        BlogDao blogDao = new BlogDao(ds);
        BlogPostDao postDao = new BlogPostDao(ds);
        BlogDaoTest.emptyDb(ds);
        blog = new Blog();
        String blogName = "Unittest for blog posts comments";
        blog.setName(blogName);
        blog.setColor("#123456");
        blogDao.saveOrUpdate(blog);
        blog = blogDao.getBlogByName(blogName);
        post = new BlogPost(blog);
        String postName = "Some Title";
        post.setTitle(postName);
        post.setContent("Some content");
        postDao.saveOrUpdate(post);
        post = postDao.getBlogPost(blog, postName);
    }

    @Test
    public void testGetComments() {
        List<BlogPostComment> comments = dao.getComments(post);
        assertEquals("No comments before saving some", 0, comments.size());
        BlogPostComment comment = new BlogPostComment(post);
        comment.setAuthor("Author");
        comment.setContent("Content");
        dao.saveOrUpdate(comment);
        comments = dao.getComments(post);
        assertEquals("One comments after save", 1, comments.size());
    }

    @Test
    public void testSave() {
        BlogPostComment comment = new BlogPostComment(post);
        comment.setAuthor("Author");
        comment.setContent("Content");
        dao.saveOrUpdate(comment);
        List<BlogPostComment> comments = dao.getComments(post);
        assertEquals("One comments after save", 1, comments.size());
        assertEquals("Correct Author", comment.getAuthor(), comments.get(0).getAuthor());
        assertEquals("Correct Content", comment.getContent(), comments.get(0).getContent());
    }

    @Test
    public void testUpdate() {
        BlogPostComment comment = new BlogPostComment(post);
        comment.setAuthor("Author");
        comment.setContent("Content");
        assertTrue("Should be new before save", comment.isNew());
        dao.saveOrUpdate(comment);
        List<BlogPostComment> comments = dao.getComments(post);
        assertEquals("One comments after save", 1, comments.size());
        BlogPostComment fromDb = comments.get(0);
        fromDb.setContent("NewContent");
        fromDb.setAuthor("NewAuthor");
        assertFalse("Should be old after read", fromDb.isNew());
        dao.saveOrUpdate(fromDb);
        comments = dao.getComments(post);
        assertEquals("One comments after update", 1, comments.size());
        assertEquals("Correct Author", fromDb.getAuthor(), comments.get(0).getAuthor());
        assertEquals("Correct Content", fromDb.getContent(), comments.get(0).getContent());
    }
}
