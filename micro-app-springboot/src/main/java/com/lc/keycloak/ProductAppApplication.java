package com.lc.keycloak;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import net.rossillo.spring.web.mvc.CacheControlHandlerInterceptor;

@SpringBootApplication
public class ProductAppApplication {

	private static Log logger = LogFactory.getLog(ProductAppApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {

//			@Override
			public void contextInitialized(ServletContextEvent sce) {
				logger.info("ServletContext initialized");
			}

//			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				logger.info("ServletContext destroyed");
			}

		};
	}

	@Bean
	public CacheControlHandlerInterceptor cacheControlHandlerInterceptor() {
		return new CacheControlHandlerInterceptor();
	}

}
