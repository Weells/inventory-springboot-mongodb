package com.brunooliveira.inventoryspringbootmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunooliveira.inventoryspringbootmongodb.domain.IngredientsFolder;

@Repository
public interface IngredientsFolderRepository extends MongoRepository<IngredientsFolder, String> {
	List<IngredientsFolder> findByCreatedByUserId(String userId);
}
