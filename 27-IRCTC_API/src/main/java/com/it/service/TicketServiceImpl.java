package com.it.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.it.bindingd.Passenger;
import com.it.bindingd.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
//	we are not using DB here because we will deploy this appl to cloud so there DB will not be available
	Map<Integer, Ticket> db=new HashMap<>();
	
	@Override
	public Ticket bookTicket(Passenger p) {
		Ticket t=new Ticket();
		Random r=new Random();
		int id=r.nextInt(1000);
		t.setTicketNum(id);
		
		// copy passenger data to ticket object
		
//		BeanUtils.copyProperties(p (source), t()target);
		BeanUtils.copyProperties(p, t);
		t.setStatus("CONFIRMED");
		db.put(id, t);
		return t;
	}

	@Override
	public Collection<Ticket> getAllTickets() {
		return db.values();
	}

}
