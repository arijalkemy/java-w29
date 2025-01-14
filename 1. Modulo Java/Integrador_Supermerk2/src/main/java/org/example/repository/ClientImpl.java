package org.example.repository;

import org.example.model.Client;

import java.util.List;
import java.util.Optional;

public class ClientImpl implements CRUD<Client>{

    private List<Client> clientes;

    @Override
    public void save(Client obj) {
        clientes.add(obj);
    }

    @Override
    public void show() {
        clientes.forEach(System.out::println);
    }

    @Override
    public Optional<Client> search(int dni) {
        Optional<Client> client = this.clientes.stream().filter(c -> c.getDni() == dni).findFirst();

        if (client.isPresent()) {
            System.out.println("Cliente con dni: " + dni + " fue encontrado, sus datos son: /b" +
                    "Nombre: " + client.get().getName() + "/b" +
                    "Apellido: " + client.get().getLastName());
            return client;
        }
        else {
            return  Optional.empty();
        }
    }

    @Override
    public void delete(Client obj) {
        clientes.remove(obj);
    }

    @Override
    public List<Client> all() {
        return clientes;
    }
}
