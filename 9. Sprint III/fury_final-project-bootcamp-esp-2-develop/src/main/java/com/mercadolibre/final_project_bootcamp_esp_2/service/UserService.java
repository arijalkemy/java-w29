package com.mercadolibre.final_project_bootcamp_esp_2.service;

import com.mercadolibre.final_project_bootcamp_esp_2.dto.UserDto;
import com.mercadolibre.final_project_bootcamp_esp_2.model.User;

import java.util.Optional;

public interface UserService {
    User registerOne(UserDto newUser);
    Optional<User> findOneByUsername(String username);
}