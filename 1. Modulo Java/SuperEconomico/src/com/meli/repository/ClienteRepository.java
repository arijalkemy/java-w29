package com.meli.repository;

import com.meli.model.Cliente;

import java.util.List;

public interface ClienteRepository {
    void save(Cliente cliente);
    Cliente getByDni(String dni);
    void deleteByDni(String dni);
    List<Cliente> getAll();
}
