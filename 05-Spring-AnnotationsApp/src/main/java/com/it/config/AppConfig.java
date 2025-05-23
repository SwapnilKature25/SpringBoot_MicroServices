package com.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.it.beans.Robot;

@Configuration
@ComponentScan(basePackages = {"com.it", "com.ibm"} )    // it will identify(search) spring bean classes available in the project
public class AppConfig {
	public AppConfig() {
		System.out.println("AppConfig.AppConfig()");
	}
	
	// for all the classes IOC will create the object
	// but for Robot class programmer will create and return object and when we explicitly used @Bean annotation then IOC will call this method and after IOC will just take that returned object
	@Bean
	public Robot buildRobot() {  // this method will be called by IOC not by programmer
		// logic
		Robot r=new Robot();
		return r;
	}
}
  