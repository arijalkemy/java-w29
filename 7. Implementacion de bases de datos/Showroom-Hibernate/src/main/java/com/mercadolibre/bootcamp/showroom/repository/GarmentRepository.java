package com.mercadolibre.bootcamp.showroom.repository;

import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.model.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GarmentRepository extends JpaRepository<Garment, Long> {

    @Query("SELECT g FROM Garment g WHERE " +
            "(:name IS NULL OR LOWER(g.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:size IS NULL OR g.size = :size)")
    List<Garment> searchAll(@Param("name") String name, @Param("size") Integer size);

}
