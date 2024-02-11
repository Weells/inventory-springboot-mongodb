package com.brunooliveira.inventoryspringbootmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunooliveira.inventoryspringbootmongodb.domain.RecipesFolder;

@Repository
public interface RecipesFolderRepository extends MongoRepository<RecipesFolder, String> {
	List<RecipesFolder> findByCreatedByUserId(String userId);
}
