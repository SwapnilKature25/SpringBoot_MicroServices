 package com.it.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class QuoteService {
	
	private static final String QUOTE_ENDPOINT="https://jsonplaceholder.typicode.com/posts";
	
	// Synchronous  - if second call depends on first call response go for synchronous
	public void getQuoteV1() {
		WebClient client=WebClient.create();
		
		System.out.println("Rest API call started");
		// logic to send the request
		Mono<String> bodyToMono = client.get()		// means to get the response
			  .uri(QUOTE_ENDPOINT)	// to which url you want to send a get request
			  .retrieve()
			  .bodyToMono(String.class);    // map the response to string variable
		
		// making webclient as synchronous by using that block()  
		System.out.println(bodyToMono.block());   // wait for the response that we are getting from Rest API
		System.out.println("Rest API call completed");
		
	}

	// ASynchronous   -  If both are independent then go for asynchronous
	public void getQuoteV2() {
		WebClient client=WebClient.create();
		
		System.out.println("Rest API call started");
		// logic to send the request
		client.get()		// means to get the response
				.uri(QUOTE_ENDPOINT)	// to which url you want to send a get request
				.header("Accept", "application/json")   // (optional) expecting type of output from provider which is represented in Accept format
				.retrieve()
				.bodyToMono(String.class)    // map the response to string variable
				.subscribe(QuoteService::handleResponse);  // after making the request subscriber is available to handle the request, u don't wait for the response you continue your execution
		System.out.println("Rest API call completed");
		// Accept and contained : contained  means in which format we are sending data to the provider
	}
	
	public static void handleResponse(String s) {
		System.out.println(s);
	}
	
}
