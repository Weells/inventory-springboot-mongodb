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
		
		Ingredient ing1 = new Ingredient(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Ingredient ing2 = new Ingredient(null, "Papel", 10, "paper", "O papel é um material constituído por elementos fibrosos de origem vegetal, geralmente distribuído sob a forma de folhas ou rolos.");
		Ingredient ing3 = new Ingredient(null, "Maçã", 2, "apple", "O fruto é globoso, com uma profunda depressão no ponto de inserção da haste, que o prende aos ramos. De coloração vermelha ou verde, pode apresentar pequenas manchas esverdeadas ou amareladas.");
		Ingredient ing4 = new Ingredient(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Ingredient ing5 = new Ingredient(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Ingredient ing6 = new Ingredient(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Ingredient ing7 = new Ingredient(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Ingredient ing8 = new Ingredient(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");
		Ingredient ing9 = new Ingredient(null, "Plastico", 5, "plastic", "Plástico, tem seu nome originário do grego \"plastikos\" que significa - capaz de ser moldado, é um material de origem natural ou sintética, obtido a partir dos derivados de petróleo ou de fontes renováveis como a cana-de-açúcar ou o milho.");

		
		ingredientRepository.saveAll(Arrays.asList(ing1, ing2, ing3, ing4, ing5, ing6, ing7, ing8, ing9));
		
		IngredientsFolder folder1 = new IngredientsFolder(null, "Ingredientes", "atom");
		folder1.getIngredients().addAll(Arrays.asList(ing1, ing2, ing3, ing4, ing5, ing6, ing7, ing8, ing9));
		
		ingredientsFolderRepository.saveAll(Arrays.asList(folder1));
		
		Recipe rec1 = new Recipe(null, "Sacola de presentes", 5, "bag", "Saco de tamanho pequeno ou médio, provido de alças e us. para transportar compras e objetos.", Arrays.asList(ing1, ing2));
		Recipe rec2 = new Recipe(null, "Caneca", 20, "cup", "A caneca é um recipiente de líquidos semelhante a um copo, porém com uma alça denominada \"asa\". ", Arrays.asList(ing1));
		Recipe rec3 = new Recipe(null, "Salada", 1, "salad", "A definição oficial de salada é de um prato, geralmente servido frio, de variados ingredientes, e que geralmente incluem vegetais, folhas verdes, pode ser acompanhada com algum tipo de carne e temperada com vinagre, azeite de oliva ou um molho.", Arrays.asList(ing3));
		
		recipeRepository.saveAll(Arrays.asList(rec1, rec2, rec3));
		
		RecipesFolder folder2 = new RecipesFolder(null, "Receitas", "book");
		RecipesFolder folder3 = new RecipesFolder(null, "Caneca", "folder");
		folder2.getRecipes().addAll(Arrays.asList(rec1, rec2, rec3));
		folder3.getRecipes().add(rec2);
		
		recipesFolderRepository.saveAll(Arrays.asList(folder2, folder3));
		
	}

}
