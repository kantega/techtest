package no.kantega.blog.initializer;

import javax.sql.DataSource;
import no.kantega.blog.db.DbStarter;
import org.apache.derby.drda.NetworkServerControl;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for blog initialization.
 */
public class DBInitializerTest {
    
    private static NetworkServerControl server;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        server = DbStarter.startDb(1529);
    }
    
    @AfterClass
    public static void tearDownClass() throws Exception {
        DbStarter.stopDb(server);
    }
    
    @Test
    public void testInitializeDatasource() throws Exception {
        DataSource ds = DBInitializer.initializeDatasource("jdbc:derby://localhost:1529/unittest_dbinit;create=true");
        assertNotNull("Should be able to get connection", ds.getConnection());
        // Second time to catch exception:
        DBInitializer.initializeDatasource("jdbc:derby://localhost:1529/blogdb;create=true");        
    }
}
