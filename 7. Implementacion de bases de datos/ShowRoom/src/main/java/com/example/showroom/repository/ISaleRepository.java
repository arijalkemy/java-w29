package com.example.showroom.repository;

import com.example.showroom.model.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISaleRepository extends JpaRepository<Sale, Long> {
}
