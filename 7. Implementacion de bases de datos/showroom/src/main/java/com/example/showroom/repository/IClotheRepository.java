package com.example.showroom.repository;

import com.example.showroom.entity.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClotheRepository extends JpaRepository<Clothe, Long> {
}
