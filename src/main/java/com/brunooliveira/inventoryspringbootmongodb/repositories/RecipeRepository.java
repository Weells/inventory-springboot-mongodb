package com.brunooliveira.inventoryspringbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunooliveira.inventoryspringbootmongodb.domain.Recipe;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, String> {

}
