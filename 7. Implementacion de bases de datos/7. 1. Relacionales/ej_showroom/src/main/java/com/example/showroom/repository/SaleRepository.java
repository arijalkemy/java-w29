package com.example.showroom.repository;

import com.example.showroom.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {
    List<Sale> findByDate(LocalDate date);
}
