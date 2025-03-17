package com.example.showroom.repository;

import com.example.showroom.model.Clothe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClotheRepository extends JpaRepository<Clothe, Integer> {
    @Query("select c from Clothe c where c.name like %:name%")
    List<Clothe> findByName(String name);

    @Query("select c from Clothe c where c.size = :size")
    List<Clothe> findBySize(String size);
}
