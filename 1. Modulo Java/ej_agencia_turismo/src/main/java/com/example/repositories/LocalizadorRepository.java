package com.example.repositories;

import com.example.entities.Localizador;

import java.util.List;

public interface LocalizadorRepository {

    List<Localizador> getAll();

    List<Localizador> getLocalizadoresByCliente(int idCliente);

    void addLocalizador(Localizador localizador);

}
