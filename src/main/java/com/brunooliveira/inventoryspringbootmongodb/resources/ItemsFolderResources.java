package com.brunooliveira.inventoryspringbootmongodb.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
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

import com.brunooliveira.inventoryspringbootmongodb.domain.ItemsFolder;
import com.brunooliveira.inventoryspringbootmongodb.domain.User;
import com.brunooliveira.inventoryspringbootmongodb.services.AuthorizationService;
import com.brunooliveira.inventoryspringbootmongodb.services.ItemsFolderService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping(value="/itemsfolders")
public class ItemsFolderResources {
	
	@Autowired
	private ItemsFolderService folderService;
	
	@Autowired
	private AuthorizationService authorizationService;

	@GetMapping
	public ResponseEntity<List<ItemsFolder>> findAll(HttpServletRequest request) {
		User user = authorizationService.getRequestUser(request);
		List<ItemsFolder> list = folderService.findByCreatedByUserId(user.getId());
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{folderId}")
	public ResponseEntity<ItemsFolder> findById(@PathVariable String folderId,
			HttpServletRequest request) {
		this.validateUserRequest(folderId, request);
		ItemsFolder obj = folderService.findById(folderId);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody ItemsFolder obj,
			HttpServletRequest request) {
		User user = authorizationService.getRequestUser(request);
		obj.setCreatedByUserId(user.getId());
		
		obj = folderService.insert(obj);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(value="/{folderId}")
	public ResponseEntity<Void> delete(@PathVariable String folderId,
			HttpServletRequest request){
		this.validateUserRequest(folderId, request);
		folderService.delete(folderId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value="/{folderId}")
	public ResponseEntity<Void> update(@RequestBody ItemsFolder updatedIngredientsFolder,
			@PathVariable String folderId, HttpServletRequest request) {
		this.validateUserRequest(folderId, request);
		updatedIngredientsFolder.setId(folderId);
		updatedIngredientsFolder = folderService.update(updatedIngredientsFolder);
		return ResponseEntity.noContent().build();
	}
	
	private User validateUserRequest(String folderId, HttpServletRequest request) {
		User user = authorizationService.getRequestUser(request);
		ItemsFolder folder = folderService.findById(folderId);
		if(!folder.getCreatedByUserId().equals(user.getId())) {
			throw new BadCredentialsException("Você não tem acesso a esta pasta");
		}
		return user;
	}
	
}
