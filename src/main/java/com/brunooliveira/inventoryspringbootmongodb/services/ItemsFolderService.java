package com.brunooliveira.inventoryspringbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brunooliveira.inventoryspringbootmongodb.domain.ItemsFolder;
import com.brunooliveira.inventoryspringbootmongodb.repositories.ItemsFolderRepository;
import com.brunooliveira.inventoryspringbootmongodb.services.exception.ObjectNotFoundException;

@Service
public class ItemsFolderService {

	@Autowired
	private ItemsFolderRepository rep;
	
	public List<ItemsFolder> findAll(){
		return rep.findAll();
	}
	
	public List<ItemsFolder> findByCreatedByUserId(String userId){
		return rep.findByCreatedByUserId(userId);
	};
	
	public ItemsFolder findById(String id) {
		Optional<ItemsFolder> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public ItemsFolder insert(ItemsFolder obj) {
		return rep.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		rep.deleteById(id);
	}
	
	public ItemsFolder update(ItemsFolder obj) {
		ItemsFolder updatedItemsFolder = findById(obj.getId());
		updateData(updatedItemsFolder, obj);
		return rep.save(updatedItemsFolder);
	}

	private void updateData(ItemsFolder updatedItemsFolder, ItemsFolder obj) {
		if(obj.getFolderName() != null) updatedItemsFolder.setFolderName(obj.getFolderName());
		if(obj.getFolderIcon() != null) updatedItemsFolder.setFolderIcon(obj.getFolderIcon());
		if(!obj.getItems().isEmpty()) updatedItemsFolder.setItems(obj.getItems());
	}
}
