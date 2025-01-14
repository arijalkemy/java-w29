package parte2;

import parte1.Cliente;
import parte1.Factura;
import parte1.Item;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Gonzalez", 12345678901L, "Juan");
        Cliente cliente2 = new Cliente("Rodriguez", 23456789012L, "Maria");
        Cliente cliente3 = new Cliente("Perez", 34567890123L, "Carlos");
        Cliente cliente4 = new Cliente("Lopez", 45678901234L, "Ana");
        Cliente cliente5 = new Cliente("Fernandez", 56789012345L, "Luis");

        Item item1 = new Item(10, 101, "Cámara", 250);
        Item item2 = new Item(5, 102, "Laptop", 750);
        Item item3 = new Item(20, 103, "Mochila", 50);
        Item item4 = new Item(15, 104, "Reloj", 150);
        Item item5 = new Item(8, 105, "Teléfono", 500);
        Item[] items = {item1, item2, item3};

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente2);
        clientes.add(cliente3);

        ArrayList<Factura> facturas = new ArrayList<>();
        Factura factura1 = new Factura(cliente1, items);

        // Llamar al método clienteEnLista
        clienteEnLista(factura1, clientes, facturas);
    }

    public static void clienteEnLista(Factura factura, ArrayList<Cliente> clientes, ArrayList<Factura> facturas) {
        boolean clienteEnLista = clientes.stream()
                .anyMatch(c -> c.getDni().equals(factura.cliente.getDni()));

        if (clienteEnLista) {
            System.out.println("El cliente está en la lista!");
            facturas.add(factura);
            System.out.println("El total es: " + factura.precioTotal);
        } else {
            System.out.println("El cliente no está en la lista!");
            clientes.add(factura.cliente);
            System.out.println("El cliente ha sido añadido a la lista!");
            facturas.add(factura);
            System.out.println("El total es: " + factura.precioTotal);
        }
    }
}