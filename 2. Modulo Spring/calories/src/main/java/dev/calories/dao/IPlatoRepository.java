package dev.calories.dao;

import dev.calories.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPlatoRepository {
    Optional<Plato> getPlatoByNombre(String nombre);
}
