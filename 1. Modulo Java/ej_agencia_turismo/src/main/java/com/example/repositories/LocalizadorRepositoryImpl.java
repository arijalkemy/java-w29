package com.example.repositories;

import com.example.entities.Localizador;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepositoryImpl implements LocalizadorRepository {

    List<Localizador> localizadores = new ArrayList<>();

    @Override
    public List<Localizador> findAll() {
        return localizadores;
    }

    @Override
    public List<Localizador> findLocalizadoresByCliente(int idCliente) {
        return localizadores.stream()
                .filter(l -> l.getCliente().getId() == idCliente)
                .toList();
    }

    @Override
    public void addLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }
}
