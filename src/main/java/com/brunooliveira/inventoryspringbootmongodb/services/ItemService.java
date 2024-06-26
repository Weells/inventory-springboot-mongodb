package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.Item;
import com.brunooliveira.inventoryspringbootmongodb.repositories.ItemRepository;
import com.brunooliveira.inventoryspringbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class ItemService {

	@Autowired
	private ItemRepository rep;
	
	public List<Item> findAll(){
		return rep.findAll();
	}
	
	public List<Item> findByCreatedByUserId(String userId){
		return rep.findByCreatedByUserId(userId);
	};
	
	public Item findById(String id) {
		Optional<Item> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Item insert(Item obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public Item update(Item obj) {
		Item updatedItem = findById(obj.getId());
		updateData(updatedItem, obj);
		return rep.save(updatedItem);
	}

	private void updateData(Item updatedItem, Item obj) {
		if(obj.getItemName() != null) updatedItem.setItemName(obj.getItemName());
		if(obj.getQuantity() != null) updatedItem.setQuantity(obj.getQuantity());
		if(obj.getItemIcon() != null) updatedItem.setItemIcon(obj.getItemIcon());
		if(!obj.getComponentItems().isEmpty()) updatedItem.setComponentItems(obj.getComponentItems());
	}
}
