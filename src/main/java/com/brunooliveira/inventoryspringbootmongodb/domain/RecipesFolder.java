package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RecipesFolder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String recipesFolderName;
	private String icon;
	
	@DBRef
	private List<Recipe> recipes = new ArrayList<>();
	
	public RecipesFolder() {}

	public RecipesFolder(String id, String recipesFolderName, String icon) {
		this.id = id;
		this.recipesFolderName = recipesFolderName;
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecipesFolderName() {
		return recipesFolderName;
	}

	public void setRecipesFolderName(String recipesFolderName) {
		this.recipesFolderName = recipesFolderName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecipesFolder other = (RecipesFolder) obj;
		return Objects.equals(id, other.id);
	}
	
}
