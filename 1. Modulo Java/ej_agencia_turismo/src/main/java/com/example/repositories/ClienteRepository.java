package com.example.repositories;

import com.example.entities.Cliente;

public interface ClienteRepository {

    void add(Cliente cliente);

    int getMaxId();

}
