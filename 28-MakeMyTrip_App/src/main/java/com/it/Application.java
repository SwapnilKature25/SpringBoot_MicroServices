package com.it;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.bindings.Ticket;
import com.it.service.MakeMyTripService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//		for testing purpose
//		MakeMyTripService bean = context.getBean(MakeMyTripService.class);
//		List<Ticket> allTickets = bean.getAllTickets();
//		allTickets.forEach(System.out::println);
		
		
	}

}
