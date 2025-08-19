package com.it.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.it.entity.Customer;
import com.it.repo.CustomerRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerRepo crepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer c = crepo.findByCname(username);
		return new User(c.getCname(), c.getCpswd(), Collections.emptyList());
	}
	
}
 