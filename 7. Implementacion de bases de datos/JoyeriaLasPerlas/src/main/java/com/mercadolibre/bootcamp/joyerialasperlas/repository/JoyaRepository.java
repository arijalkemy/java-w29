package com.mercadolibre.bootcamp.joyerialasperlas.repository;

import com.mercadolibre.bootcamp.joyerialasperlas.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaRepository extends JpaRepository<Joya, Integer> {



}
