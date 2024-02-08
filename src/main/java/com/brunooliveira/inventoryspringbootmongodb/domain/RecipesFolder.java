package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("recipes_folders")
public class RecipesFolder extends UserCollections implements Serializable {
	private static final long serialVersionUID = 1L;

	@DBRef
	private List<Recipe> recipes = new ArrayList<>();
	
	public RecipesFolder() {}

	public RecipesFolder(String id, String folderName, String folderIcon) {
		super(id, folderName, folderIcon);
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

}
