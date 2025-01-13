package com.example.demo.integradores.agencia_turismo;

import java.util.HashMap;
import java.util.Map;


class ClientRepository {
    private Map<String, Client> clients;

    public ClientRepository() {
        this.clients = new HashMap<>();
    }

    public Client getClient(String id) {
        return clients.get(id);
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
    }

    public boolean exists(String id) {
        return clients.containsKey(id);
    }

}
