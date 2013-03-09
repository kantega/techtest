package no.kantega.blog.popularity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import no.kantega.blog.model.Blog;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for popularity statistics.
 */
public class StatsTest {
    
    private Stats stats;
    private Blog blog1;
    private Blog blog2;
    private Blog blogNew;
    
    @Before
    public void setUp() {
        stats = new Stats();
        blog1 = new Blog();
        blog1.setName("Blog 1");
        blog1.setId(123);
        blog2 = new Blog();
        blog2.setName("Blog 2");
        blog2.setId(432);
        blogNew = new Blog();
    }
    
    @Test
    public void testAddVisitTo() {
        assertEquals("No visits before visit", 0, stats.getVisits(Collections.singletonList(blog1)).get(0).getVisits());
        stats.addVisitTo(blog1);
        assertEquals("One visits after one visit", 1, stats.getVisits(Collections.singletonList(blog1)).get(0).getVisits());
        stats.addVisitTo(blog1);
        stats.addVisitTo(blog2);
        assertEquals("Two visits after visit", 2, stats.getVisits(Collections.singletonList(blog1)).get(0).getVisits());
        assertEquals("Blog 2: One visits after visit", 1, stats.getVisits(Collections.singletonList(blog2)).get(0).getVisits());
    }

    @Test
    public void testAddVisitToNewBlog() {
        assertEquals("No visits before visit", 0, stats.getVisits(Collections.singletonList(blogNew)).get(0).getVisits());
        stats.addVisitTo(blogNew);
        assertEquals("No visits after visit", 0, stats.getVisits(Collections.singletonList(blogNew)).get(0).getVisits());
    }

    @Test
    public void testGetVisitsEmpty() {
        assertTrue("No visits when we read no blogs", stats.getVisits(Collections.EMPTY_LIST).isEmpty());
    }

    @Test
    public void testGetVisitsSorted() {
        stats.addVisitTo(blog1);
        stats.addVisitTo(blog1);
        stats.addVisitTo(blog2);
        List<BlogVisits> visits = stats.getVisits(Arrays.asList(blog1, blog2));
        assertEquals("Should contain both blogs", 2, visits.size());
        assertEquals("Blog 1 is visited the most", blog1, visits.get(0).getBlog());
        assertEquals("Blog 2 is visited least frequend", blog2, visits.get(1).getBlog());
        assertEquals("Blog 1 has 2 visits", 2, visits.get(0).getVisits());
        assertEquals("Blog 2 has 1 visits", 1, visits.get(1).getVisits());
    }
}
