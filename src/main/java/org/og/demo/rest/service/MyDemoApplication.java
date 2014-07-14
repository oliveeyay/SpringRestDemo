package org.og.demo.rest.service;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.og.demo.rest.util.CORSResponseFilter;
import org.og.demo.rest.util.LoggingResponseFilter;

/**
 * Registers the components to be used by the JAX-RS application
 * 
 * @author Olivier Goutay
 * 
 */
public class MyDemoApplication extends ResourceConfig {

	/**
	 * Register JAX-RS application components
	 */
	public MyDemoApplication() {
		register(RequestContextFilter.class);
		register(OrderRestService.class);
		register(JacksonFeature.class);
		register(LoggingResponseFilter.class);
		register(CORSResponseFilter.class);
	}
}
