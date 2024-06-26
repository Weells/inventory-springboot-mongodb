package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document("items")
@JsonPropertyOrder({"id", "created_by_user_id", "item_name", "quantity", "item_icon", "description"})
public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	@Field("created_by_user_id")
	private String createdByUserId;
	@Field("item_name")
	private String itemName;
	private Integer quantity;
	@Field("item_icon")
	private String itemIcon;
	private String description;
	
	@DBRef
	private List<Item> componentItems = new ArrayList<>();
	
	public Item() {
	}

	public Item(String id, String itemName, Integer quantity, String itemIcon, String description) {
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.itemIcon = itemIcon;
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatedByUserId() {
		return createdByUserId;
	}

	public void setCreatedByUserId(String createdByUserId) {
		this.createdByUserId = createdByUserId;
	}

	@JsonProperty("item_name")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonProperty("item_icon")
	public String getItemIcon() {
		return itemIcon;
	}

	public void setItemIcon(String itemIcon) {
		this.itemIcon =itemIcon;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Item> getComponentItems() {
		return componentItems;
	}

	public void setComponentItems(List<Item> componentItems) {
		this.componentItems = componentItems;
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
		Item other = (Item) obj;
		return Objects.equals(id, other.id);
	}
}
