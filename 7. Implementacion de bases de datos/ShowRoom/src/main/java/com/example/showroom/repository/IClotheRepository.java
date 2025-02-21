package com.example.showroom.repository;

import com.example.showroom.model.entity.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClotheRepository extends JpaRepository<Clothe, Long> {
    List<Clothe> findAllBySize(String size);
    List<Clothe> findAllByNameContainingIgnoreCase(String name);
}
