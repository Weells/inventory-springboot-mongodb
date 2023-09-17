package com.brunooliveira.inventoryspringbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunooliveira.inventoryspringbootmongodb.domain.Recipe;
import com.brunooliveira.inventoryspringbootmongodb.services.RecipeService;

@RestController
@RequestMapping(value="/recipes")
public class RecipeResource {

	@Autowired
	private RecipeService service;
	
	@GetMapping
	public ResponseEntity<List<Recipe>> findAll() {
		List<Recipe> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
