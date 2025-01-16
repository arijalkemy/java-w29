package org.example.ej_calculadora_calorias.Repository;

import org.example.ej_calculadora_calorias.Entity.Plato;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IPlatoRepository {

    List<Plato> getByNomes(List<String> nome);

    Optional<Plato> getByName(String name);

}
