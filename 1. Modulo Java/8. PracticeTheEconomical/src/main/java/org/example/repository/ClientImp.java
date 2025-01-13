package org.example.repository;

import org.example.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientImp implements ICRUDRepository<Client> {
    List<Client> clients = new ArrayList<>();

    @Override
    public void save(Client client) {
        clients.add(client);
    }

    @Override
    public void printAll() {
        clients.forEach(System.out::println);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clients.stream()
                .filter(client -> client.getDni().equals(id))
                .findFirst()
                .or(Optional::empty);
    }

    @Override
    public void delete(Long id) {
        clients.removeIf(client -> client.getDni().equals(id));
    }

    @Override
    public List<Client> findAll() {
        return List.of();
    }
}
