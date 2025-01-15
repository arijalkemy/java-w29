package com.example.ejemploSpring.repository;

import com.example.ejemploSpring.entity.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepositoryImpl implements IClientRepository{

    private List<Client> clients = new ArrayList<>();

    @Override
    public Client addClient(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public Optional<Client> findClientByName(String name) {
        return clients.stream().filter(c -> c.getName().equalsIgnoreCase(name)).findFirst();
    }
}
