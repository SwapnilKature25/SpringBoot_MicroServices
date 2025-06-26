package com.it.service;

import java.util.Collection;

import com.it.bindingd.Passenger;
import com.it.bindingd.Ticket;

public interface TicketService {
	
	public Ticket bookTicket(Passenger p);
	
	public Collection<Ticket> getAllTickets();
	
}
