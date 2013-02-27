package no.kantega.blog.db;

import org.apache.derby.drda.NetworkServerControl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;

/**
 *
 */
public class DbStarter {

    public static void main(String[] args) throws Exception {

        System.setProperty("visualvm.display.name", "TechBlogDB");
        System.out.println("Starting database");

        NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("localhost"),1527);


        server.start(null);

        //server.setMaxThreads(5);


        System.out.println("Database server started, press ENTER to shut down");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        server.shutdown();


        System.out.println("Database server successfully shut down");
    }
}
