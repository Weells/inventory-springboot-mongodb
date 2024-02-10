package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.User;
import com.brunooliveira.inventoryspringbootmongodb.domain.infra.security.CookieService;
import com.brunooliveira.inventoryspringbootmongodb.domain.infra.security.TokenService;
import com.brunooliveira.inventoryspringbootmongodb.repositories.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class AuthorizationService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByLogin(username);
	}
	
	public User getRequestUser(HttpServletRequest request) {
		Optional<String> token = CookieService.getCookieValue(request, "token");
		String login = tokenService.validateToken(token.get());
		User user = (User) userRepository.findByLogin(login);
		return user;
	}
	
}
