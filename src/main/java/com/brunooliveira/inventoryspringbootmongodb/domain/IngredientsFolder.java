package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IngredientsFolder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String ingredientsFolderName;
	private String icon;
	
	@DBRef
	private List<Ingredient> ingredients = new ArrayList<>();
	
	public IngredientsFolder() {}

	public IngredientsFolder(String id, String ingredientsFolderName, String icon) {
		this.id = id;
		this.ingredientsFolderName = ingredientsFolderName;
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIngredientsFolderName() {
		return ingredientsFolderName;
	}

	public void setIngredientsFolderName(String ingredientsFolderName) {
		this.ingredientsFolderName = ingredientsFolderName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
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
		IngredientsFolder other = (IngredientsFolder) obj;
		return Objects.equals(id, other.id);
	}
	
}
