package com.example.ejemploSpring.repository;

import com.example.ejemploSpring.entity.Client;

import java.util.Optional;

public interface IClientRepository {
    Client addClient(Client client);
    Optional<Client> findClientByName(String name);
}
