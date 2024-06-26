package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ingredients_folders")
public class IngredientsFolder extends UserCollections implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public IngredientsFolder(String id, String folderName, String folderIcon) {
		super(id, folderName, folderIcon);
	}

	@DBRef
	private List<Ingredient> ingredients = new ArrayList<>();
	
	public IngredientsFolder() {}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
}
