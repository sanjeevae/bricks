package com.order.bricks;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ServletContextHandler restContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
    	restContextHandler.setContextPath("/");

        Server jettyServer = new Server(8080);
        jettyServer.setHandler(restContextHandler);

        ServletHolder jerseyServlet = restContextHandler.addServlet(
             org.glassfish.jersey.servlet.ServletContainer.class, "/*");
        jerseyServlet.setInitOrder(0);

        // Tells the Jersey Servlet which REST service/class to load.
        jerseyServlet.setInitParameter(
           "jersey.config.server.provider.packages",        "com.order.bricks");

        try {
            jettyServer.start();
            jettyServer.join();
            
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            jettyServer.destroy();
        }
    }
}
