package no.kantega.blog.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import org.apache.derby.drda.NetworkServerControl;

/**
 * Class that gives a simple way to start and stop the database.
 */
@SuppressWarnings("PMD.SystemPrintln")
public final class DbStarter {

    private static final int PORT_NUMBER = 1527;
    
    private DbStarter() {}
    
    /**
     * Main method. Starts and stops the database.
     * 
     * @param args Arguments to the main method. Needs none.
     * @throws Exception In case it fails to start the database.
     */
    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    public static void main(String[] args) throws Exception {
        System.setProperty("visualvm.display.name", "TechBlogDB");
        System.out.println("Starting database");
        NetworkServerControl server = startDb(PORT_NUMBER);
        
        //server.setMaxThreads(5);

        System.out.println("Database server started, press ENTER to shut down");
        waitForEnter();

        stopDb(server);
        System.out.println("Database server successfully shut down");
    }
    
    /**
     * Starts the database server.
     * 
     * @param portNr The port to start the server on
     * @return Database server
     * @throws Exception If the database can't be started
     */
    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    public static NetworkServerControl startDb(int portNr) throws Exception {
        System.setProperty("derby.system.home", "target");
        NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("localhost"), portNr);
        server.start(null);
        waitForDbStarted(server);
        return server;
    }
    
    /**
     * Waits for the database to start.
     * 
     * @param server The server to wait for
     * @throws InterruptedException In case the wait is interrupted
     */
    private static void waitForDbStarted(NetworkServerControl server) throws InterruptedException {
        long maxSleepTime = 10l * 1000l;
        long endTime = System.currentTimeMillis() + maxSleepTime;
        boolean ping = false;
        while (!ping && System.currentTimeMillis() < endTime) {
            ping = doPing(server);
        }
        if (!ping) {
            throw new RuntimeException("Failed to start database in reasonable time");
        }
    } 
    
    private static boolean doPing(NetworkServerControl server) throws InterruptedException {
        boolean ping = false;
        try {
            server.ping();
            ping = true;
        } catch (Exception e) {
            Thread.sleep(100);
        }
        return ping;
    }
    
    /**
     * Stops the database server.
     * 
     * @param server The server to stop
     * @throws Exception 
     */
    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    public static void stopDb(NetworkServerControl server) throws Exception {
        server.shutdown();        
    }
    
    private static void waitForEnter() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        br.readLine();        
    }
}
