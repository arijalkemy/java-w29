package com.example.integrador.repository;

import com.example.integrador.model.Clothes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClothesRepo extends JpaRepository<Clothes, Long> {
    List<Clothes> findClothesBySizeEqualsIgnoreCase(String size);

    List<Clothes> findClothesByNameLikeIgnoreCase(String name);
}
