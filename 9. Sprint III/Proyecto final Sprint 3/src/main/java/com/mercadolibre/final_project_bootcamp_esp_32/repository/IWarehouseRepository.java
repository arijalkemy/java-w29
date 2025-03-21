package com.mercadolibre.final_project_bootcamp_esp_32.repository;

import com.mercadolibre.final_project_bootcamp_esp_32.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Integer> {
}
