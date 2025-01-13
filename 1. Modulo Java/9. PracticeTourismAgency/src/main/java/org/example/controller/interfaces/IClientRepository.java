package org.example.controller.interfaces;

import org.example.model.Client;

public interface IClientRepository {
    void add(Client client);
    Client getById(String dni);
}
