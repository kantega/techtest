package no.kantega.blog.popularity;

import no.kantega.blog.model.Blog;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Simple unit test for blog visits.
 */
public class BlogVisitsTest {
    
    @Test
    public void testGetBlog() {
        Blog blog = new Blog();
        blog.setName("Test blog");
        BlogVisits bv = new BlogVisits(blog, 123l);
        assertEquals("Should be correct blog", blog, bv.getBlog());
    }

    @Test
    public void testGetVisits() {
        Blog blog = new Blog();
        blog.setName("Test blog");
        BlogVisits bv = new BlogVisits(blog, 123l);
        assertEquals("Should be correct number of visits", 123l, bv.getVisits());
    }
}
