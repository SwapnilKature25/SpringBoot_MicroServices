package com.it.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.it.bindings.Passenger;
import com.it.bindings.Ticket;

@Service
public class MakeMyTripService {
	
	public Ticket bookTicket(Passenger p) {
/*		String apiUrl = "http://43.205.144.253:8080/ticket";
		This is the public IP address or domain name of the server where your Spring Boot app is deployed.
		Localhost (for local dev): http://localhost
		Public IP (on a cloud server like AWS): http://43.205.144.253
		Domain name (if configured): http://example.com
*/	
		String apiUrl = "http://localhost:8083/ticket";
		
//		It is a predefined class in the spring Web MVC to send Http request to the URl
		RestTemplate rt=new RestTemplate();
//		it is used to send POST request to the given URL
//		to send that HTTP POST request to the consumer, we are using a postForEntity()
//		if we specify String.class it will represent raw json.
		ResponseEntity<Ticket> forEntity = rt.postForEntity(apiUrl, p, Ticket.class);  // Ticket.class represents what response we are expecting from provider 
		
		Ticket body = forEntity.getBody();
		
		return body;
	}
	
	
	public List<Ticket> getAllTickets(){
		String apiUrl = "http://localhost:8083/tickets";
		RestTemplate rt=new RestTemplate();
		
		ResponseEntity<Ticket[]> forEntity = rt.getForEntity(apiUrl, Ticket[].class);
		Ticket[] body = forEntity.getBody();
		List<Ticket> tickets = Arrays.asList(body);
		return tickets;
	}
	 
}
