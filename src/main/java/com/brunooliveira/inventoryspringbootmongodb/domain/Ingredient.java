package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ingredient implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String ingredientName;
	private Integer quantity;
	private Integer icon;
	
	public Ingredient() {
	}

	public Ingredient(String id, String ingredientName, Integer quantity, Integer icon) {
		this.id = id;
		this.ingredientName = ingredientName;
		this.quantity = quantity;
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getIcon() {
		return icon;
	}

	public void setIcon(Integer icon) {
		this.icon = icon;
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
		Ingredient other = (Ingredient) obj;
		return Objects.equals(id, other.id);
	}
	
}
