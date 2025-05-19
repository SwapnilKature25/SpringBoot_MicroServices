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

/*
 [2m2025-05-17T21:27:24.705+05:30[0;39m [32m INFO[0;39m [35m6344[0;39m [2m--- [01-SpringBootApp] [           main] [0;39m[36mo.s.boot.SpringApplication              [0;39m [2m:[0;39m  _________                             .__.__     
 /   _____/_  _  _______  ______   ____ |__|  |    
 \_____  \\ \/ \/ /\__  \ \____ \ /    \|  |  |    
 /        \\     /  / __ \|  |_> >   |  \  |  |__  
/_______  / \/\_/  (____  /   __/|___|  /__|____/  
        \/              \/|__|        \/           

[2m2025-05-17T21:27:24.742+05:30[0;39m [32m INFO[0;39m [35m6344[0;39m [2m--- [01-SpringBootApp] [           main] [0;39m[36mcom.it.Application                      [0;39m [2m:[0;39m Starting Application using Java 19.0.1 with PID 6344 (C:\Users\swapn\01CJ\Spring_Boot_MicroServices\01-SpringBootApp\target\classes started by swapn in C:\Users\swapn\01CJ\Spring_Boot_MicroServices\01-SpringBootApp)
[2m2025-05-17T21:27:24.743+05:30[0;39m [32m INFO[0;39m [35m6344[0;39m [2m--- [01-SpringBootApp] [           main] [0;39m[36mcom.it.Application                      [0;39m [2m:[0;39m No active profile set, falling back to 1 default profile: "default"
UserDao::Constructor
UserService::constructor
Pwdutilas::constructor
[2m2025-05-17T21:27:25.209+05:30[0;39m [32m INFO[0;39m [35m6344[0;39m [2m--- [01-SpringBootApp] [           main] [0;39m[36mcom.it.Application                      [0;39m [2m:[0;39m Started Application in 0.741 seconds (process running for 1.19)
org.springframework.context.annotation.AnnotationConfigApplicationContext

 * */
