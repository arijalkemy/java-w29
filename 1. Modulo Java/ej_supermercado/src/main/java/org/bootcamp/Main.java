package org.bootcamp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1234567 ,"Lucas", "Rodriguez");
        Cliente cliente2 = new Cliente(987654321 ,"German", "Beder");
        Cliente cliente3 = new Cliente(1459642, "Alfredo", "Montes de oca");

        List<Cliente> clientes = new ArrayList<>(Arrays.asList(cliente1, cliente2, cliente3));

        mostrarClientes(clientes);

        clientes.remove(cliente2);
        mostrarClientes(clientes);

        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dni de la persona a borrar");
        Integer dni = teclado.nextInt();

        borrarClientePorDni(clientes, dni);
        mostrarClientes(clientes);

        List<Factura> facturas = new ArrayList<>();

        Item item1 = new Item(1, "Leche", 2, 100.5);
        Item item2 = new Item(2, "Mostaza", 1, 150.0);
        Item item3 = new Item(3, "Cerveza", 6, 200.5);
        List<Item> items = new ArrayList<>(Arrays.asList(item1, item2, item3));

        Factura factura = new Factura(1, cliente1, items);
        agregarFactura(facturas, factura, clientes);

        mostrarFacturas(facturas);
        mostrarClientes(clientes);
    }

    private static void mostrarClientes(List<Cliente> clientes) {
        clientes.forEach(System.out::println);
        System.out.println("------------------------");
    }

    private static void borrarClientePorDni(List<Cliente> clientes, Integer dni) {
        Cliente clienteborrado = clientes.stream().filter(cliente -> cliente.getDni().equals(dni))
                .findFirst()
                .orElse(null);

        if(clienteborrado != null) {
            clientes.remove(clienteborrado);
            System.out.println("Cliente Borrado: " + clienteborrado);
            System.out.println("------------------------");
        } else {
            System.out.println("No se encontro a un cliente con ese DNI");
        }

    }

    private static void agregarFactura(List<Factura> facturas, Factura factura, List<Cliente> clientes) {
        if(!clientes.contains(factura.getCliente())){
            clientes.add(factura.getCliente());
        }

        facturas.add(factura);
    }

    private static void mostrarFacturas(List<Factura> facturas) {
        facturas.forEach(System.out::println);
        System.out.println("------------------------");
    }
}