package com.brunooliveira.inventoryspringbootmongodb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("items_folders")
public class ItemsFolder extends UserCollections implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public ItemsFolder(String id, String folderName, String folderIcon) {
		super(id, folderName, folderIcon);
	}

	@DBRef
	private List<Item> items = new ArrayList<>();
	
	public ItemsFolder() {}

	public List<Item> getItems() {
		return items;
	}
	
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
