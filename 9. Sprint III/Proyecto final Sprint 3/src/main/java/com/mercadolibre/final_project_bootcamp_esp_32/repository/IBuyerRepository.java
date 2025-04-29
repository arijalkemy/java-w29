package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBuyerRepository extends JpaRepository<Buyer, Integer> {
    Buyer findByEmail(String email);
}
