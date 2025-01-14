package com.example.repository;

import com.example.model.Cliente;

public interface ClienteRepository {

    void add(Cliente cliente);

    int getMaxId();

}
