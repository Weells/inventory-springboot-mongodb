package com.brunooliveira.inventoryspringbootmongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.brunooliveira.inventoryspringbootmongodb.domain.ItemsFolder;

@Repository
public interface ItemsFolderRepository extends MongoRepository<ItemsFolder, String> {
	List<ItemsFolder> findByCreatedByUserId(String userId);
}
