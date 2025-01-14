package com.bootcamp.CalculadoraCalorias.repository;

import com.bootcamp.CalculadoraCalorias.entity.Ingrediente;
import com.bootcamp.CalculadoraCalorias.entity.Plato;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImpl implements PlatoRepository {

    List<Plato> platos = List.of(
            new Plato("Pizza",
                    List.of(new Ingrediente("Masa", 30),
                    new Ingrediente("Tomate", 10))),
            new Plato("Milanesa",
                    List.of(new Ingrediente("Carne", 5),
                    new Ingrediente("Pan rallado", 20))));

    @Override
    public Optional<Plato> devolverPlatoPorNombre(String nombre) {
        return platos.stream().filter(p -> p.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }
}
