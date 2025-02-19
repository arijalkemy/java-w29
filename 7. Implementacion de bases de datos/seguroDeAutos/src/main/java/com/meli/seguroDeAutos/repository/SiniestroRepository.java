package com.meli.seguroDeAutos.repository;

import com.meli.seguroDeAutos.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroRepository extends JpaRepository<Siniestro, Integer> {
}
