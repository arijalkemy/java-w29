package com.example.repositories;

import com.example.entities.Localizador;

import java.util.List;

public interface LocalizadorRepository {
    List<Localizador> findAll();

    List<Localizador> findLocalizadoresByCliente(int idCliente);

    void addLocalizador(Localizador localizador);
}
