package com.brunooliveira.inventoryspringbootmongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.brunooliveira.inventoryspringbootmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{
	UserDetails findByLogin(String login);
}
