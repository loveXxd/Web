package com.wqc.hand;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.WebAppRootListener;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebAppRootContext implements ServletContextInitializer {
	    private String bufferSize="10000000";

	    @Override
	    public void onStartup(ServletContext servletContext) throws ServletException {
	        servletContext.addListener(WebAppRootListener.class);
	        servletContext.setInitParameter("org.apache.tomcat.websocket.textBufferSize", bufferSize);
	    }
 
}
