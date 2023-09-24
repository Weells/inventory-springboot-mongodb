package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Recipe implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String recipeName;
	private Integer quantity;
	private String icon;
	private String description;
	
	@DBRef
	List<Ingredient> ingredients = new ArrayList<>();
	
	public Recipe() {
	}

	public Recipe(String id, String recipeName, Integer quantity, String icon, String description, List<Ingredient> ingredients) {
		this.id = id;
		this.recipeName = recipeName;
		this.quantity = quantity;
		this.icon = icon;
		this.description = description;
		this.ingredients = ingredients;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
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
		Recipe other = (Recipe) obj;
		return Objects.equals(id, other.id);
	}

}
