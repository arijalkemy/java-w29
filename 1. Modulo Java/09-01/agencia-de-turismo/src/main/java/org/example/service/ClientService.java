package org.example.service;

import org.example.repository.ClientRepository;

public class ClientService {
    private ClientRepository repository;

    public ClientService() {
        repository = new ClientRepository();
    }
}
