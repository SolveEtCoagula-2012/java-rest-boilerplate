package com.rest.test.restprj;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import com.rest.test.dao.PersistenceUtil;

public class MainApp {

	private static final String PATH_RESOURCES = "com.rest.test.resource";
	private static final Logger LOG = Logger.getLogger(MainApp.class);

	public static void main(String[] args) throws Exception {
		PropertyConfigurator.configure(MainApp.class.getClassLoader().getResourceAsStream("conf/log4j.properties"));

		LOG.info("Starting TestRestApp...");
		Server jettyServer = new Server(8080);

		LOG.info("Server created ");
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		PersistenceUtil.getEntityManager();

		LOG.info("Server created ");
		context.setContextPath("/");
		jettyServer.setHandler(context);

		LOG.info("Configuring TestApp 0Servlet ");
		ServletHolder serHol = context.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/*");
		serHol.setInitOrder(0);

		// Tells the Jersey Servlet which REST service/class to load.
		serHol.setInitParameter("jersey.config.server.provider.packages", PATH_RESOURCES);

		try {
			jettyServer.start();
			jettyServer.join();
		} catch (Exception exc) {
			LOG.error(exc.getMessage());
			System.exit(0);
		} finally {
			jettyServer.destroy();
		}

	}
}
