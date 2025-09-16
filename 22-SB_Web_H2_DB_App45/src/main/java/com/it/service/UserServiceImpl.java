package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.entity.User;
import com.it.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean saveUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser.getUid()!= null;
	}

}
