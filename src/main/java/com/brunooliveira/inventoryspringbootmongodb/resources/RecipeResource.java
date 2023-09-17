package com.brunooliveira.inventoryspringbootmongodb.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunooliveira.inventoryspringbootmongodb.domain.Ingredient;
import com.brunooliveira.inventoryspringbootmongodb.domain.Recipe;

@RestController
@RequestMapping(value="/recipes")
public class RecipeResource {

	@GetMapping
	public ResponseEntity<List<Recipe>> findAll() {
		Ingredient ing1 = new Ingredient("1", "Papel", 5, 1);
		Ingredient ing2 = new Ingredient("2", "Borracha", 2, 3);
		Recipe rec1 = new Recipe("1", "Sacola de presentes", 1, 10, Arrays.asList(ing1, ing2));
		return ResponseEntity.ok().body(Arrays.asList(rec1));
	}
}
