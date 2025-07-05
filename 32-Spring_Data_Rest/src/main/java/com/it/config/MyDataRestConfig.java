package com.it.config;

import org.hibernate.boot.Metadata;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.it.entity.Book;

// to disable few Http methods from RestRepository
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
//		You cannot send put & delete request for this application
		HttpMethod[] unsupportedMethods = { HttpMethod.PUT, HttpMethod.DELETE };
		config.getExposureConfiguration()
			  .forDomainType(Book.class)
			  .withItemExposure( (metadata,http)-> http.disable(unsupportedMethods))  // single record operation
			  .withCollectionExposure( (metadata,http)-> http.disable(unsupportedMethods));   // group of records operations
 	}
	
}
