 package com.it.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class QuoteService {
	
	private static final String QUOTE_ENDPOINT="https://type.fit/api/quotes";
	public void getQuoteV1() {
		WebClient client=WebClient.create();
		
		System.out.println("Rest API call started");
		// logic to send the request
		Mono<String> bodyToMono = client.get()		// get request means to get the response
			  .uri(QUOTE_ENDPOINT)	// to which url you want to send a get request
			  .retrieve()
			  .bodyToMono(String.class);    // map the response to string variable
		System.out.println(bodyToMono.block());   // wait for the response that we are getting from Rest API
		System.out.println("Rest API call completed");
		
	}
}
