package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.IngredientsFolder;
import com.brunooliveira.inventoryspringbootmongodb.repositories.IngredientsFolderRepository;
import com.brunooliveira.inventoryspringbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class IngredientsFolderService {

	@Autowired
	private IngredientsFolderRepository rep;
	
	public List<IngredientsFolder> findAll(){
		return rep.findAll();
	}
	
	public List<IngredientsFolder> findByCreatedByUserId(String userId){
		return rep.findByCreatedByUserId(userId);
	};
	
	public IngredientsFolder findById(String id) {
		Optional<IngredientsFolder> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public IngredientsFolder insert(IngredientsFolder obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public IngredientsFolder update(IngredientsFolder obj) {
		IngredientsFolder updatedIngredientsFolder = findById(obj.getId());
		updateData(updatedIngredientsFolder, obj);
		return rep.save(updatedIngredientsFolder);
	}

	private void updateData(IngredientsFolder updatedIngredientsFolder, IngredientsFolder obj) {
		if(obj.getFolderName() != null) updatedIngredientsFolder.setFolderName(obj.getFolderName());
		if(obj.getFolderIcon() != null) updatedIngredientsFolder.setFolderIcon(obj.getFolderIcon());
		if(!obj.getIngredients().isEmpty()) updatedIngredientsFolder.setIngredients(obj.getIngredients());
	}
}
