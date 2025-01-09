package com.mdaneri;

import com.mdaneri.interfaces.Repository;
import com.mdaneri.models.Bill;
import com.mdaneri.models.Client;

import java.util.*;

public class ClientsRepository implements Repository<String, Client> {

    private Set<Client> clients;

    public ClientsRepository() {
        this.clients = new HashSet<>();
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clients);
    }

    @Override
    public Optional<Client> findById(String dni) {
        return clients.stream().filter(c -> c.getDni().equals(dni)).findFirst();
    }

    @Override
    public void save(Client client) {
        clients.add(client);
    }

    @Override
    public void delete(Client client) {
        clients.remove(client);
    }

    @Override
    public void update(Client client) {
        clients
                .stream()
                .filter(c -> client.getDni().equals(c.getDni()))
                .findFirst()
                .ifPresent(b -> {
                    b.setFirstname(client.getFirstname());
                    b.setLastname(client.getLastname());
                });
    }
}
