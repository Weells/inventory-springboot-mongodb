package com.brunooliveira.inventoryspringbootmongodb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunooliveira.inventoryspringbootmongodb.domain.IngredientsFolder;
import com.brunooliveira.inventoryspringbootmongodb.services.IngredientsFolderService;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping(value="/ingredientsfolders")
public class IngredientsFolderResources {
	
	@Autowired
	private IngredientsFolderService service;

	@GetMapping
	public ResponseEntity<List<IngredientsFolder>> findAll() {
		List<IngredientsFolder> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<IngredientsFolder> findById(@PathVariable String id) {
		IngredientsFolder obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody IngredientsFolder obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> update(@RequestBody IngredientsFolder updatedIngredientsFolder, @PathVariable String id){
		updatedIngredientsFolder.setId(id);
		updatedIngredientsFolder = service.update(updatedIngredientsFolder);
		return ResponseEntity.noContent().build();
	}
}
