package com.brunooliveira.inventoryspringbootmongodb.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunooliveira.inventoryspringbootmongodb.domain.User;
import com.brunooliveira.inventoryspringbootmongodb.domain.dto.AuthenticationDTO;
import com.brunooliveira.inventoryspringbootmongodb.domain.dto.LoginResponseDTO;
import com.brunooliveira.inventoryspringbootmongodb.domain.dto.RegisterDTO;
import com.brunooliveira.inventoryspringbootmongodb.domain.infra.security.TokenService;
import com.brunooliveira.inventoryspringbootmongodb.repositories.UserRepository;

import jakarta.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping(value="/auth")
public class AuthenticationResource {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository repository;
	
	@Autowired
	TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody @Validated AuthenticationDTO data, HttpServletResponse response) {
		UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
		Authentication auth = this.authenticationManager.authenticate(usernamePassword);
		String token = tokenService.generateToken((User) auth.getPrincipal());
		
		return ResponseEntity.ok().body(new LoginResponseDTO(token));
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
