package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.RecipesFolder;
import com.brunooliveira.inventoryspringbootmongodb.repositories.RecipesFolderRepository;
import com.brunooliveira.inventoryspringbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class RecipesFolderService {

	@Autowired
	private RecipesFolderRepository rep;
	
	public List<RecipesFolder> findAll(){
		return rep.findAll();
	}
	
	public RecipesFolder findById(String id) {
		Optional<RecipesFolder> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public RecipesFolder insert(RecipesFolder obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public RecipesFolder update(RecipesFolder obj) {
		RecipesFolder updatedRecipesFolder = findById(obj.getId());
		updateData(updatedRecipesFolder, obj);
		return rep.save(updatedRecipesFolder);
	}

	private void updateData(RecipesFolder updatedRecipesFolder, RecipesFolder obj) {
		if(obj.getFolderName() != null) updatedRecipesFolder.setFolderName(obj.getFolderName());
		if(obj.getFolderIcon() != null) updatedRecipesFolder.setFolderIcon(obj.getFolderIcon());
		if(!obj.getRecipes().isEmpty()) updatedRecipesFolder.setRecipes(obj.getRecipes());
	}

	public List<RecipesFolder> findByCreatedByUserId(String userId) {
		return rep.findByCreatedByUserId(userId);
	}
}
