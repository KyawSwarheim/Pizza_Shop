package com.PizzaOrder.PizzaOrderingSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.PizzaOrder.PizzaOrderingSystem.Repository.UserRepository;
import com.PizzaOrder.PizzaOrderingSystem.entity.CustomerUserDetails;
import com.PizzaOrder.PizzaOrderingSystem.entity.User;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repo.findByEmail(email);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomerUserDetails(user);
	}

}
