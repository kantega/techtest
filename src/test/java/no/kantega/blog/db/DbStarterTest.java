package no.kantega.blog.db;

import org.apache.derby.drda.NetworkServerControl;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Unit test for DBStarter.
 */
public class DbStarterTest {
    
    @Test
    public void testStartStopDb() throws Exception {
        NetworkServerControl server = DbStarter.startDb(1528);
        server.ping();
        DbStarter.stopDb(server);
        try {
            server.ping();
            fail("Server should be stopped");
        } catch (Exception ex) {
            assertTrue("Should contain error message, but was: " + ex.getMessage(), ex.getMessage().contains("Could not connect"));
        }
    }

}
