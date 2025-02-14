package com.example.showroom.repository;

import com.example.showroom.model.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClotheRepository extends JpaRepository<Clothe, Integer> {
    List<Clothe> findBySize(String size);

    List<Clothe> findByNameContaining(String name);

    @Query("SELECT c FROM Sale s JOIN s.saleDetails sd JOIN sd.clothe c WHERE s.id = :saleId")
    List<Clothe> findAllBySaleId(Integer saleId);
}
