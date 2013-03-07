package no.kantega.blog.db;

import org.apache.derby.drda.NetworkServerControl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 * Class that gives a simple way to start and stop the database.
 */
public final class DbStarter {

    private static final int PORT_NUMBER = 1527;
    
    private DbStarter() {}
    
    public static void main(String[] args) throws Exception {
        System.setProperty("derby.system.home", "target");
        System.setProperty("visualvm.display.name", "TechBlogDB");

        System.out.println("Starting database");

        NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("localhost"), PORT_NUMBER);
        server.start(null);

        //server.setMaxThreads(5);

        System.out.println("Database server started, press ENTER to shut down");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        br.readLine();

        server.shutdown();

        System.out.println("Database server successfully shut down");
    }
}
