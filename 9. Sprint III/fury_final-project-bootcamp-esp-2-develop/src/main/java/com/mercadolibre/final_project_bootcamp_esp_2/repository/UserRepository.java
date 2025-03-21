package com.mercadolibre.final_project_bootcamp_esp_2.repository;

import com.mercadolibre.final_project_bootcamp_esp_2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}