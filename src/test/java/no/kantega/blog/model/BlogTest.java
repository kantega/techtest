package no.kantega.blog.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for Blog model object.
 */
public class BlogTest {

    private Blog blog;
    
    @Before
    public void setUp() {
        blog = new Blog();
    }
    
    @Test
    public void testSetGetId() {
        long id = 1234l;
        blog.setId(id);
        assertEquals("should have correct id", id, blog.getId());
    }

    @Test
    public void testSetGetName() {
        String name = "testName";
        blog.setName(name);
        assertEquals("Should have correct name", name, blog.getName());
    }

    @Test
    public void testSetGetColor() {
        String color = "#deadbe";
        blog.setColor(color);
        assertEquals("Should have correct color", color, blog.getColor());
    }

    @Test
    public void testIsNew() {
        assertTrue("Should be new before setting the id", blog.isNew());
        blog.setId(123l);
        assertFalse("Should be old after setting the id", blog.isNew());
    }

    @Test
    public void testGetLinkId() {
        blog.setName("Jørgens blog");
        assertEquals("Should have correct link id", "J%C3%B8rgens+blog", blog.getLinkId());
    }

    @Test
    public void testGetLinkIdMissingName() {
        assertNull("Should be null when we have no name", blog.getLinkId());
    }

}
