package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	// write your code here
        //Parte 1
        Cliente cliente = new Cliente(1,"Joaquin", "Andrada");
        Cliente cliente1 = new Cliente(2, "Agustin", "Ojeda");
        Cliente cliente2 = new Cliente(3, "Roman", "Rodriguez");

        List<Cliente> listadoClientes = new ArrayList();
        listadoClientes.add(cliente);
        listadoClientes.add(cliente1);
        listadoClientes.add(cliente2);


        System.out.println("--------------------------- Imprimiendo lista de clientes -------------------------");
        listadoClientes.forEach(c -> System.out.println(c.toString()));
        System.out.println("--------------------------- Eliminamos a Joaquin de la lista -----------------------");
        listadoClientes.remove(cliente);
        listadoClientes.forEach(c -> System.out.println(c.toString()));
        System.out.println("--------------------------- Ingresa el numero de DNI del cliente a consultar ----------------------");
        Scanner scanner = new Scanner(System.in);
        Integer dniConsultar = scanner.nextInt();
        Cliente clienteConsultado = listadoClientes.stream()
                .filter(c -> c.getDni().equals(dniConsultar))
                .findFirst().orElse(null);
        if (null != clienteConsultado){
            System.out.println(clienteConsultado.toString());
        }
        else{
            System.out.println("No se encontró el cliente con el documento: "+dniConsultar);
        }

        //Parte 2
        Item item1 = new Item("1A", "Arcor", 20.5, 2);
        Item item2 = new Item("2A", "Arcor", 15.0, 1);
        Item item3 = new Item("3A", "LaVirginia", 40.1,2);

        List<Item> listadoItems = new ArrayList<>();
        listadoItems.add(item1);
        listadoItems.add(item2);
        listadoItems.add(item3);

        Factura factura = new Factura(1,listadoItems,cliente1,
                listadoItems.stream().mapToDouble(Item::getPrecioTotal).sum());

        System.out.println("El Importe total de la factura es de: "+factura.getImporteTotal());


    }
}
