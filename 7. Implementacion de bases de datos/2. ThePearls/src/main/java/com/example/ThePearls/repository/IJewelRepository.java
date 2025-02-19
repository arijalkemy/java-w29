package com.example.ThePearls.repository;

import com.example.ThePearls.entity.Jewel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelRepository extends JpaRepository<Jewel, Long> {
}
