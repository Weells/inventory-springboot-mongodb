package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RecipesFolder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private Integer icon;
	
	private List<Recipe> recipes = new ArrayList<>();
	
	public RecipesFolder() {}

	public RecipesFolder(String id, String name, Integer icon) {
		this.id = id;
		this.name = name;
		this.icon = icon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIcon() {
		return icon;
	}

	public void setIcon(Integer icon) {
		this.icon = icon;
	}

	public List<Recipe> getIngredients() {
		return recipes;
	}

	public void setIngredients(List<Recipe> recipes) {
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
