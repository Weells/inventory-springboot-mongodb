package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.Recipe;
import com.brunooliveira.inventoryspringbootmongodb.repositories.RecipeRepository;
import com.brunooliveira.inventoryspringbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository rep;
	
	public List<Recipe> findAll(){
		return rep.findAll();
	}
	
	public Recipe findById(String id) {
		Optional<Recipe> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Recipe insert(Recipe obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public Recipe update(Recipe obj) {
		Recipe updatedRecipe = findById(obj.getId());
		updateData(updatedRecipe, obj);
		return rep.save(updatedRecipe);
	}

	private void updateData(Recipe updatedRecipe, Recipe obj) {
		if(obj.getRecipeName() != null) updatedRecipe.setRecipeName(obj.getRecipeName());
		if(obj.getQuantity() != null) updatedRecipe.setQuantity(obj.getQuantity());
		if(obj.getIcon() != null) updatedRecipe.setIcon(obj.getIcon());
		if(!obj.getIngredients().isEmpty()) updatedRecipe.setIngredients(obj.getIngredients());
	}
}
