package org.example.repository;

import org.example.model.Client;

import java.util.List;
import java.util.Optional;

public class ClientRepository implements Repository<Long, Client> {
    @Override
    public List<Client> findAll() {
        return List.of();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Boolean save(Client entity) {
        return null;
    }

    @Override
    public Boolean delete(Client entity) {
        return null;
    }
}
