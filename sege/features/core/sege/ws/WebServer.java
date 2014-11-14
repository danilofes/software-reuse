package sege.ws;

import java.util.EventListener;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap;


public class WebServer {
	
	private static final int PORT = 8080;
	
	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);
		
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setEventListeners(new EventListener[]{new ResteasyBootstrap()});
        ServletHolder holder = new ServletHolder(new HttpServletDispatcher());
        holder.setInitParameter("javax.ws.rs.Application", "sege.ws.WebApplication");
        context.addServlet(holder, "/*");
 
        server.setHandler(context);
        server.start();
        server.join();
	}

}