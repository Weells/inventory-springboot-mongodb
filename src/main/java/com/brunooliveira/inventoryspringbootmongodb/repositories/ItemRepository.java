package com.brunooliveira.inventoryspringbootmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunooliveira.inventoryspringbootmongodb.domain.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
	List<Item> findByCreatedByUserId(String userId);
}
