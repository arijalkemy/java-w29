package com.example.jewelry.repository;

import com.example.jewelry.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JewelryRepository extends JpaRepository<Jewelry, Long> {
}
