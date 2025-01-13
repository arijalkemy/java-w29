package org.example.controller.repository;

import org.example.controller.interfaces.IClientRepository;
import org.example.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IClientRepository {

    private List<Client> clients = new ArrayList<>();

    @Override
    public void add(Client client) {
        clients.add(client);
    }

    @Override
    public Client getById(String dni) {
        return clients.stream()
                .filter(client -> client.getDni().equals(dni))
                .findFirst()
                .orElse(null);
    }
}
