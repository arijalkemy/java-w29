package com.org.meli.showroom.repository;

import com.org.meli.showroom.model.Garment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGarmentRepository extends JpaRepository<Garment, Long> {

    @Query("SELECT g FROM Garment g WHERE LOWER(g.size) = LOWER(:size)")
    List<Garment> findGarmentBySizeIgnoreCase(@Param("size") String size);

    @Query("SELECT g FROM Garment g WHERE LOWER(g.name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Garment> findByNameContainingIgnoreCase(@Param("name") String name);
}
