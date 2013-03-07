package no.kantega.blog.model;

import java.sql.Timestamp;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for comments model object.
 */
public class BlogPostCommentTest {
    
    private Blog blog;
    private BlogPost post;
    private BlogPostComment comment;
    
    @Before
    public void setUp() {
        blog = new Blog();
        post = new BlogPost(blog);
        comment = new BlogPostComment(post);
    }
    
    @Test
    public void testSetGetBlogPostCommentId() {
        long id = 697l;
        comment.setBlogPostCommentId(id);
        assertEquals("Has correct id", id, comment.getBlogPostCommentId());
    }

    @Test
    public void testSetGetContent() {
        String content = "This blog post sucks!";
        comment.setContent(content);
        assertEquals("Should have correct content", content, comment.getContent());
    }

    @Test
    public void testSetGetAuthor() {
        String author = "Øystein Øye";
        comment.setAuthor(author);
        assertEquals("Has correct author", author, comment.getAuthor());
    }

    @Test
    public void testIsNew() {
        assertTrue("Should be new before setting the id", comment.isNew());
        comment.setBlogPostCommentId(123l);
        assertFalse("Should be old after setting the id", comment.isNew());
    }

    @Test
    public void testGetBlogPost() {
        assertEquals("Shoud be same blog post", post, comment.getBlogPost());
    }

    @Test
    public void testSetGetPublishDate() {
        DateTime now = new DateTime();
        comment.setPublishDate(new Timestamp(now.toDate().getTime()));
        assertEquals("Should be same date", now, comment.getPublishDate());
    }

    @Test
    public void testGetPublishDateInFormat() {
        DateTime now = new DateTime();
        comment.setPublishDate(new Timestamp(now.toDate().getTime()));
        assertEquals("Should be date of today", String.valueOf(now.getYear()), comment.getPublishDateInFormat("yyyy"));
    }

}
