package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.Ingredient;
import com.brunooliveira.inventoryspringbootmongodb.repositories.IngredientRepository;
import com.brunooliveira.inventoryspringbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository rep;
	
	public List<Ingredient> findAll(){
		return rep.findAll();
	}
	
	public Ingredient findById(String id) {
		Optional<Ingredient> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Ingredient insert(Ingredient obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public Ingredient update(Ingredient obj) {
		Ingredient updatedIngredient = findById(obj.getId());
		updateData(updatedIngredient, obj);
		return rep.save(updatedIngredient);
	}

	private void updateData(Ingredient updatedIngredient, Ingredient obj) {
		updatedIngredient.setName(obj.getName());
		updatedIngredient.setQuantity(obj.getQuantity());
		updatedIngredient.setIcon(obj.getIcon());
	}
}
