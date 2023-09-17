package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.Recipe;
import com.brunooliveira.inventoryspringbootmongodb.repositories.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository rep;
	
	public List<Recipe> findAll(){
		return rep.findAll();
	}
	
}
