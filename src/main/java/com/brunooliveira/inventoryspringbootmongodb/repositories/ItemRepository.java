package com.brunooliveira.inventoryspringbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunooliveira.inventoryspringbootmongodb.domain.Ingredient;

@Repository
public interface IngredientRepository extends MongoRepository<Ingredient, String> {

}
