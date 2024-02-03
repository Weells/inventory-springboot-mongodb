package com.brunooliveira.inventoryspringbootmongodb.domain;

public record RegisterDTO(String login, String password, UserRole role) {

}
