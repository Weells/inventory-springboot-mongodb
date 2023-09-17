package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.Ingredient;
import com.brunooliveira.inventoryspringbootmongodb.repositories.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository rep;
	
	public List<Ingredient> findAll(){
		return rep.findAll();
	}
	
}
