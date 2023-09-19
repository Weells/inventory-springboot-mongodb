package com.brunooliveira.inventoryspringbootmongodb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.brunooliveira.inventoryspringbootmongodb.domain.RecipesFolder;
import com.brunooliveira.inventoryspringbootmongodb.services.RecipesFolderService;

@RestController
@RequestMapping(value="/recipesfolders")
public class RecipesFolderResource {

	@Autowired
	private RecipesFolderService service;
	
	@GetMapping
	public ResponseEntity<List<RecipesFolder>> findAll() {
		List<RecipesFolder> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<RecipesFolder> findById(@PathVariable String id){
		RecipesFolder obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody RecipesFolder obj){
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
	public ResponseEntity<Void> update(@RequestBody RecipesFolder updatedRecipesFolder, @PathVariable String id){
		updatedRecipesFolder.setId(id);
		updatedRecipesFolder = service.update(updatedRecipesFolder);
		return ResponseEntity.noContent().build();
	}
}
