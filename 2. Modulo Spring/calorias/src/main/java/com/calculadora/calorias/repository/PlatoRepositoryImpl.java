package com.calculadora.calorias.repository;

import com.calculadora.calorias.model.Plato;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {
    private final List<Plato> platos = List.of(
            new Plato("Pizza", List.of(
                    "Queso mozzarella",
                    "Jamón",
                    "Tomates"
            ))
    );

    public List<Plato> getPlatos() {
        return this.platos;
    }

    public Optional<Plato> getPlato(String plato) {
        return this.platos.stream().filter(p -> p.getName().equals(plato)).findFirst();
    }
}
