package com.bootcamp.dao;

import com.bootcamp.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlatoRepository {
    Optional<Plato> getPlatoByNombre(String nombre);
}
