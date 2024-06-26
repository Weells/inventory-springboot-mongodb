package com.brunooliveira.inventoryspringbootmongodb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunooliveira.inventoryspringbootmongodb.domain.Item;
import com.brunooliveira.inventoryspringbootmongodb.domain.User;
import com.brunooliveira.inventoryspringbootmongodb.services.AuthorizationService;
import com.brunooliveira.inventoryspringbootmongodb.services.ItemService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping(value="/items")
public class ItemResource {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private AuthorizationService authorizationService;

	@GetMapping
	public ResponseEntity<List<Item>> findAll(HttpServletRequest request) {
		User user = authorizationService.getRequestUser(request);
		List<Item> list = itemService.findByCreatedByUserId(user.getId());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Item> findById(@PathVariable String id,
			HttpServletRequest request) {
		this.validateUserRequest(id, request);
		Item obj = itemService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody Item obj,
			HttpServletRequest request) {
		User user = authorizationService.getRequestUser(request);
		obj.setCreatedByUserId(user.getId());
		
		obj = itemService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id,
			HttpServletRequest request){
		this.validateUserRequest(id, request);
		itemService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody Item updatedIngredient,
			@PathVariable String id, HttpServletRequest request){
		this.validateUserRequest(id, request);
		updatedIngredient.setId(id);
		updatedIngredient = itemService.update(updatedIngredient);
		return ResponseEntity.noContent().build();
	}
	
	private User validateUserRequest(String itemId, HttpServletRequest request) {
		User user = authorizationService.getRequestUser(request);
		Item item = itemService.findById(itemId);
		if(!item.getCreatedByUserId().equals(user.getId())) {
			throw new BadCredentialsException("Você não tem acesso a esta pasta");
		}
		return user;
	}
}
