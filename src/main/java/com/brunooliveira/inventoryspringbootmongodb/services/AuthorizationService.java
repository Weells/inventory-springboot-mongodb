package com.brunooliveira.inventoryspringbootmongodb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.repositories.UserRepository;

@Service
public class AuthorizationService implements UserDetailsService{

	@Autowired
	private UserRepository rep;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return rep.findByLogin(username);
	}

}
