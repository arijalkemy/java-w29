package com.mercadolibre.final_project_bootcamp_esp_2.repository;

import com.mercadolibre.final_project_bootcamp_esp_2.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IWarehouseRepository extends JpaRepository<Warehouse, Long> {
}
