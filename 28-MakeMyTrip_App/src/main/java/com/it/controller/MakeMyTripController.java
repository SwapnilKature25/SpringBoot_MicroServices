package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.it.bindings.Passenger;
import com.it.bindings.Ticket;
import com.it.service.MakeMyTripService;

public class MakeMyTripController {
	
	@Autowired
	private MakeMyTripService service;
	
	@PostMapping("/ticket")
	public String ticketBooking(@ModelAttribute("p") Passenger p, Model model) {
		Ticket bookTicket = service.bookTicket(p);
		model.addAttribute("msg", "Your Ticket Booked, ID : "+bookTicket.getTicketNum());
		return "bookTicket";
	}
	
	
	@GetMapping("/book-ticket")
	public String bookTicket(Model model) {
		model.addAttribute("p",new Passenger());
		return "bookTicket";
	}
	
	
//	to send data from controller to Ui we are going to use Model Object
	@GetMapping("/")
	public String index(Model model) {
		List<Ticket> allTickets = service.getAllTickets();
		model.addAttribute("tickets",allTickets);
		return "index";
	}
}
