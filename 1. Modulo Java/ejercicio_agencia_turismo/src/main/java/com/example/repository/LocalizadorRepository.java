package com.example.repository;

import com.example.model.Localizador;

import java.util.List;

public interface LocalizadorRepository {

    List<Localizador> getAll();

    List<Localizador> getLocalizadoresByCliente(int idCliente);

    void addLocalizador(Localizador localizador);

}
