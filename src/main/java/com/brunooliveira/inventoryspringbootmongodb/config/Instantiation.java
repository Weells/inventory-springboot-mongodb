package com.brunooliveira.inventoryspringbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.brunooliveira.inventoryspringbootmongodb.domain.Ingredient;
import com.brunooliveira.inventoryspringbootmongodb.domain.IngredientsFolder;
import com.brunooliveira.inventoryspringbootmongodb.domain.Recipe;
import com.brunooliveira.inventoryspringbootmongodb.domain.RecipesFolder;
import com.brunooliveira.inventoryspringbootmongodb.repositories.IngredientRepository;
import com.brunooliveira.inventoryspringbootmongodb.repositories.IngredientsFolderRepository;
import com.brunooliveira.inventoryspringbootmongodb.repositories.RecipeRepository;
import com.brunooliveira.inventoryspringbootmongodb.repositories.RecipesFolderRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private IngredientsFolderRepository ingredientsFolderRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private RecipesFolderRepository recipesFolderRepository;
	
	@Override
	public void run(String... args) throws Exception {

		ingredientRepository.deleteAll();
		ingredientsFolderRepository.deleteAll();
		recipeRepository.deleteAll();
		recipesFolderRepository.deleteAll();
		
		Ingredient ing1 = new Ingredient(null, "Plastico", 5, 2);
		Ingredient ing2 = new Ingredient(null, "Papel", 10, 4);
		
		ingredientRepository.saveAll(Arrays.asList(ing1, ing2));
		
		IngredientsFolder folder1 = new IngredientsFolder(null, "Pasta de ingredientes", 1);
		folder1.getIngredients().addAll(Arrays.asList(ing1, ing2));
		
		ingredientsFolderRepository.saveAll(Arrays.asList(folder1));
		
		Recipe rec1 = new Recipe(null, "Sacola de presentes", 5, 29, Arrays.asList(ing1, ing2));
		Recipe rec2 = new Recipe(null, "Caneca", 20, 33, Arrays.asList(ing1));
		
		recipeRepository.saveAll(Arrays.asList(rec1, rec2));
		
		RecipesFolder folder2 = new RecipesFolder(null, "Pasta de receitas", 3);
		folder2.getRecipes().addAll(Arrays.asList(rec1, rec2));
		
		recipesFolderRepository.saveAll(Arrays.asList(folder2));
		
	}

}
