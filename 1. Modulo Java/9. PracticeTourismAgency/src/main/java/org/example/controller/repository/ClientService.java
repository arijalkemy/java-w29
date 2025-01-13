package org.example.controller.repository;

import org.example.model.Client;

public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService() {
        this(new ClientRepository());
    }

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        clientRepository.add(client);
    }
}
