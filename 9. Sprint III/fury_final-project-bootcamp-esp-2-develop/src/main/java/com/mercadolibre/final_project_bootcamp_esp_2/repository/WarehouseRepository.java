package com.mercadolibre.final_project_bootcamp_esp_2.repository;

import com.mercadolibre.final_project_bootcamp_esp_2.model.Sector;
import com.mercadolibre.final_project_bootcamp_esp_2.model.Warehouse;
import com.mercadolibre.final_project_bootcamp_esp_2.model.util.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findBySupervisorId(Long supervisorId);

    @Query("SELECT s FROM Sector s " +
            "JOIN s.warehouse w " +
            "WHERE w.id = :id " +
            "AND s.productType = :type")
    Optional<Sector> findWarehouseSectionsForProductType(@Param("id") Long id, @Param("type") ProductType type);

}
