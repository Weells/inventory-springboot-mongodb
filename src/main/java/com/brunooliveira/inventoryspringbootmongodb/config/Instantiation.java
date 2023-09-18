package com.brunooliveira.inventoryspringbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brunooliveira.inventoryspringbootmongodb.domain.Ingredient;
import com.brunooliveira.inventoryspringbootmongodb.domain.Recipe;
import com.brunooliveira.inventoryspringbootmongodb.repositories.IngredientRepository;
import com.brunooliveira.inventoryspringbootmongodb.repositories.RecipeRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Override
	public void run(String... args) throws Exception {

		ingredientRepository.deleteAll();
		recipeRepository.deleteAll();
		
		Ingredient ing1 = new Ingredient(null, "Plastico", 5, 2);
		Ingredient ing2 = new Ingredient(null, "Papel", 10, 4);
		
		ingredientRepository.saveAll(Arrays.asList(ing1, ing2));
		
		Recipe rec1 = new Recipe(null, "Sacola de presentes", 5, 29, Arrays.asList(ing1, ing2));
		Recipe rec2 = new Recipe(null, "Caneca", 20, 33, Arrays.asList(ing1));
		
		recipeRepository.saveAll(Arrays.asList(rec1, rec2));
		
	}

}
