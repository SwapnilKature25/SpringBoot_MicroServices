package com.it.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.it.bindings.Passenger;
import com.it.bindings.Ticket;

import reactor.core.publisher.Mono;

@Service
public class MakeMyTripService {
	
	public Mono<Ticket> bookTicket(Passenger p) {
		String apiUrl = "http://localhost:8083/ticket";
		WebClient webClient=WebClient.create();
		Mono<Ticket> bodyToMono = webClient.post()
				.uri(apiUrl)
				.body(BodyInserters.fromValue(p))
				.retrieve()
				.bodyToMono(Ticket.class);
		return bodyToMono;
		
//		BodyInserters means to send the data in the request body. whatever the data we have in object format, that object should be converted to json and json data should go in the body.  
	}
	
	
	public Mono<Ticket[]> getAllTickets(){
		String apiUrl = "http://localhost:8083/tickets";
		WebClient webClient = WebClient.create();
		Mono<Ticket[]> bodyToMono = webClient.get()
				 .uri(apiUrl)
				 .retrieve()
				 .bodyToMono(Ticket[].class);
		return bodyToMono;
	}
	
	
}
