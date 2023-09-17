package com.brunooliveira.inventoryspringbootmongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunooliveira.inventoryspringbootmongodb.domain.Ingredient;
import com.brunooliveira.inventoryspringbootmongodb.services.IngredientService;

@RestController
@RequestMapping(value="/ingredients")
public class IngredientResource {
	
	@Autowired
	private IngredientService service;

	@GetMapping
	public ResponseEntity<List<Ingredient>> findAll() {
		List<Ingredient> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
