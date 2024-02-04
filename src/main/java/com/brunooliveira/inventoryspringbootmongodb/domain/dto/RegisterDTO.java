package com.brunooliveira.inventoryspringbootmongodb.domain.dto;

import com.brunooliveira.inventoryspringbootmongodb.domain.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}
