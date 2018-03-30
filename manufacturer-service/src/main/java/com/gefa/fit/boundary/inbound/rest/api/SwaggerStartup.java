package com.gefa.fit.boundary.inbound.rest.api;

import io.swagger.jaxrs.config.BeanConfig;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Setup the Swagger service. The service version is read from the manifest.
 * 
 * @author oliver.osterholz@gefa.de
 */
public class SwaggerStartup extends HttpServlet {

    private static final long serialVersionUID = 5743664568429403916L;
    private static final Log LOG = LogFactory.getLog(SwaggerStartup.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        LOG.info("Initializing Swagger for TicketProducer.");
        initSwagger("1.0.0");
    }

    private static void initSwagger(String serviceVersion) {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("EKF Tool Services");
        beanConfig.setDescription("RESTful web services for EKF Tool");
        beanConfig.setVersion(serviceVersion);
        beanConfig.setSchemes(new String[] { "http", "https" });
        beanConfig.setBasePath("fit-tool-rest-easy");
        beanConfig.setResourcePackage("com.gefa.fit.resources");
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
    }
}
