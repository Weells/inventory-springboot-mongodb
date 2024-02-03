package com.brunooliveira.inventoryspringbootmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunooliveira.inventoryspringbootmongodb.domain.AuthenticationDTO;
import com.brunooliveira.inventoryspringbootmongodb.domain.RegisterDTO;
import com.brunooliveira.inventoryspringbootmongodb.domain.User;
import com.brunooliveira.inventoryspringbootmongodb.domain.UserRole;
import com.brunooliveira.inventoryspringbootmongodb.repositories.UserRepository;

@RestController
@RequestMapping(value="/auth")
public class AuthenticationResource {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository repository;
	
	@PostMapping("/login")
	public ResponseEntity<Void> login(@RequestBody @Validated AuthenticationDTO data) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		var auth = this.authenticationManager.authenticate(usernamePassword);
		
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/register")
	public ResponseEntity<Void> register(@RequestBody @Validated RegisterDTO data){
		if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
		User newUser = new User(null, data.login(), encryptedPassword, data.role());
		
		this.repository.save(newUser);
		return ResponseEntity.ok().build();
	}
}
