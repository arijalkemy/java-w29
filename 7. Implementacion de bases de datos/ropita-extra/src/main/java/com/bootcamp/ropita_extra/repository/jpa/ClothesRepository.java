package com.bootcamp.ropita_extra.repository.jpa;

import com.bootcamp.ropita_extra.model.Clothes;
import com.bootcamp.ropita_extra.repository.IClothesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothesRepository extends JpaRepository<Clothes, String>, IClothesRepository {
    List<Clothes> findByNameContainingIgnoreCase(String name);
}
