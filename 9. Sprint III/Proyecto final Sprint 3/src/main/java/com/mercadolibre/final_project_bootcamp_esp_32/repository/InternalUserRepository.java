package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.InternalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternalUserRepository extends JpaRepository<InternalUser, Integer> {
    InternalUser findByEmail(String email);
}

