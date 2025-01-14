package com.bootcamp.dao;

import com.bootcamp.model.Plato;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PlatoRepositoryImpl implements IPlatoRepository{

    private List<Plato> platosList = new ArrayList<>();

    @Override
    public Optional<Plato> getPlatoByNombre(String nombre){
        return platosList.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }


}
