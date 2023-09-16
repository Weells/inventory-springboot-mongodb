package com.brunooliveira.inventoryspringbootmongodb.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brunooliveira.inventoryspringbootmongodb.domain.Ingredient;

@RestController
@RequestMapping(value="/ingredients")
public class IngredientResource {

	@GetMapping
	public ResponseEntity<List<Ingredient>> findAll() {
		Ingredient ing1 = new Ingredient("1", "Papel", 5, 1);
		Ingredient ing2 = new Ingredient("2", "Borracha", 2, 3);
		List<Ingredient> list = new ArrayList<>();
		list.addAll(Arrays.asList(ing1, ing2));
		
		return ResponseEntity.ok().body(list);
	}
}
