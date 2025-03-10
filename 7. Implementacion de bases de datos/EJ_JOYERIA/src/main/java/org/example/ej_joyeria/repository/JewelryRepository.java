package org.example.ej_joyeria.repository;

import org.example.ej_joyeria.model.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JewelryRepository extends JpaRepository<Jewelry, Long> {
}
