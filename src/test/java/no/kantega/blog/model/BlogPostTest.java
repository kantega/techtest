package no.kantega.blog.model;

import java.sql.Timestamp;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for blog posts.
 */
public class BlogPostTest {

    private Blog blog;
    private BlogPost post;
    
    @Before
    public void setUp() {
        blog = new Blog();
        post = new BlogPost(blog);
    }
    
    @Test
    public void testSetGetBlogPostId() {
        long id = 12345l;
        post.setBlogPostId(id);
        assertEquals("Should have correct id", id, post.getBlogPostId());
    }

    @Test
    public void testSetGetContent() {
        String content = "This is my post content";
        post.setContent(content);
        assertEquals("Should have correct content", content, post.getContent());
    }

    @Test
    public void testSetGetTitle() {
        String title = "My blog post";
        post.setTitle(title);
        assertEquals("Should have correct title", title, post.getTitle());
    }

    @Test
    public void testGetBlog() {
        assertEquals("Should be same blog", blog, post.getBlog());
    }

    @Test
    public void testIsNew() {
        assertTrue("Should be new before setting the id", post.isNew());
        post.setBlogPostId(123l);
        assertFalse("Should be old after setting the id", post.isNew());
    }

    @Test
    public void testSetGetPublishDate() {
        DateTime now = new DateTime();
        post.setPublishDate(new Timestamp(now.toDate().getTime()));
        assertEquals("Should be same date", now, post.getPublishDate());
    }

    @Test
    public void testGetPublishDateInFormat() {
        DateTime now = new DateTime();
        post.setPublishDate(new Timestamp(now.toDate().getTime()));
        assertEquals("Should be date of today", String.valueOf(now.getYear()), post.getPublishDateInFormat("yyyy"));
    }

    @Test
    public void testSetGetCommentCount() {
        int count = 543;
        post.setCommentCount(count);
        assertEquals("ShoUld have correct count", count, post.getCommentCount());
    }

    @Test
    public void testGetLinkId() {
        post.setTitle("Jørgens blog post");
        assertEquals("Should have correct link id", "J%C3%B8rgens+blog+post", post.getLinkId());
    }
}
