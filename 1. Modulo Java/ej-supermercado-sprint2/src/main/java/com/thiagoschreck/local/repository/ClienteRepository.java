package com.thiagoschreck.local.repository;

import com.thiagoschreck.local.model.Cliente;
import java.util.Optional;

public class ClienteRepository extends CrudImpl<Cliente> {

    @Override
    public Optional<Cliente> getById(String dni) {
        return getItems().stream()
                .filter(cliente -> cliente.getDni().equals(dni))
                .findFirst();
    }
}
