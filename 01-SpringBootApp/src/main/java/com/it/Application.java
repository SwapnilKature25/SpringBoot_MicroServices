package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.it.util.PwdUtils;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		<artifactId>spring-boot-starter</artifactId>
//		System.out.println(context.getClass().getName());   // for standalone app , it use AnnotationConfigApplicationContext to start IOC container
		
//		<artifactId>spring-boot-starter-web</artifactId>
		System.out.println(context.getClass().getName());   // for webapp , it use AnnotationConfigServletWebServerApplicationContext to start IOC container
		
		
	}
	
	// to create the object on our own
	@Bean   
	public PwdUtils getInstance()
	{
		return new PwdUtils();
	}

}
