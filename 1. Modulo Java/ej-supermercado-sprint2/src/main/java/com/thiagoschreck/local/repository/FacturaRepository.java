package com.thiagoschreck.local.repository;

import com.thiagoschreck.local.model.Cliente;
import com.thiagoschreck.local.model.Factura;
import com.thiagoschreck.local.model.Producto;

import java.util.List;

public class FacturaRepository extends CrudImpl<Factura> {
    ClienteRepository clienteRepository;

    public FacturaRepository(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void addItem(Factura factura) {
    }

    public void crearFactura(String dni, List<Producto> productos) {
        Cliente cliente = clienteRepository.getItems().stream()
                .filter(c -> c.getDni().equals(dni))
                .findFirst()
                .orElse(null);
        if (cliente == null) {
            System.out.println("No existe un cliente con el DNI especificado.");
            return;
        }
        items.add(new Factura(cliente, productos));
    }
}
