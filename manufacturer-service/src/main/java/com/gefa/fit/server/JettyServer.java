package com.gefa.fit.server;

import com.gefa.fit.boundary.inbound.rest.error.handlers.ExceptionHandler;
import com.gefa.fit.boundary.inbound.rest.error.handlers.NoSuchManufacturerExceptionHandler;
import com.gefa.fit.boundary.inbound.rest.resources.ManufacturerResourceImpl;
import org.eclipse.jetty.server.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;
import org.jboss.weld.environment.servlet.Listener;

/**
 * UndertowServer class.
 *
 */
public class JettyServer {


    static final String APPLICATION_PATH = "/";
    static final String CONTEXT_ROOT = "/fit-asset-service";

	public static void startServer() throws Exception{

        final int port = 8082;
        final Server jetty = new Server(port);

		WebAppContext context = new WebAppContext();
    	context.setContextPath(CONTEXT_ROOT);
    	context.setResourceBase("src/main/resources");
    	jetty.setHandler(context);

        final ServletHolder restEasyServlet = new ServletHolder(new HttpServletDispatcher());
        restEasyServlet.setInitParameter("resteasy.servlet.mapping.prefix", APPLICATION_PATH);
        restEasyServlet.setInitParameter("javax.ws.rs.Application", MyApp.class.getName());
        context.addServlet(restEasyServlet, APPLICATION_PATH + "*");

        context.setInitParameter("resteasy.injector.factory", "org.jboss.resteasy.cdi.CdiInjectorFactory");
		context.addEventListener(new Listener());
//		context.addEventListener(new JMSServletContextListener());


		jetty.start();

		jetty.join();


	}

    /**
	 * UndertowServer method.
	 *
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws Exception {
	    startServer();
	}

	@ApplicationPath("/")
	public static class MyApp extends Application {

		@Override
		public Set<Class<?>> getClasses() {
			HashSet<Class<?>> classes = new HashSet<Class<?>>();
			classes.add(ManufacturerResourceImpl.class);
			classes.add(ExceptionHandler.class);
			classes.add(NoSuchManufacturerExceptionHandler.class);
			return classes;
		}
	}

}
