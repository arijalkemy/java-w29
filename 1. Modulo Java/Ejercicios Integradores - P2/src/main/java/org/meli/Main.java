package org.meli;

import org.meli.models.Cliente;
import org.meli.models.Factura;
import org.meli.models.Item;
import org.meli.services.ClienteCRUD;
import org.meli.services.FacturaCRUD;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteCRUD clienteCRUD = new ClienteCRUD();
        FacturaCRUD facturaCRUD = new FacturaCRUD();

        Cliente cliente = obtenerORegistrarCliente("1", "Juan", "juan@example.com", clienteCRUD);

        List<Item> items = new ArrayList<>();
        items.add(new Item("1", "agua", 2.5, 4));
        items.add(new Item("2", "banana", 1.2, 2));

        Factura factura = new Factura("1", cliente, items);
        facturaCRUD.create(factura);

        System.out.println("Factura creada. Total: " + factura.getTotal());
    }

    private static Cliente obtenerORegistrarCliente(String id, String nombre, String email, ClienteCRUD clienteCRUD) {
        return clienteCRUD.read(id).orElseGet(() -> {
            Cliente nuevoCliente = new Cliente(id, nombre, email);
            clienteCRUD.create(nuevoCliente);
            return nuevoCliente;
        });
    }
}