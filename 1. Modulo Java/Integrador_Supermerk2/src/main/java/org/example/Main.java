package org.example;

import org.example.model.Client;
import org.example.model.Invoice;
import org.example.model.Item;
//import org.example.model.Supermarket;
import org.example.repository.ClientImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        /*
        //Genero los clientes
        Client client1 = new Client(35949747,"Carolina","Altamiranda");
        Client client2 = new Client(35949748,"Florencia","Markov");
        Client client3 = new Client(35949749,"Micaela","Markov");

        //Genero la coleccion de clientes
        List<Client> clientes = new ArrayList<>();
        //Guardo los clientes en la coleccion
        clientes.add(client1);
        clientes.add(client2);
        clientes.add(client3);

        //Genero el supermercado
        Supermarket market = new Supermarket(clientes);

        System.out.println("Punto 1");
        System.out.println("-------");
        System.out.println(" ");

        //Imprimo Clientes
        market.printClients();
        System.out.println(" ");

        System.out.println("Punto 2");
        System.out.println("-------");
        System.out.println(" ");

        //Borro Cliente e imprimo
        market.deleteClient(client1);
        market.printClients();
        System.out.println(" ");

        System.out.println("Punto 3");
        System.out.println("-------");
        System.out.println(" ");

        // Solicitar DNI al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número de DNI del cliente:");
        int inputDni = scanner.nextInt();

        // Buscar el cliente por DNI
        Client foundClient = market.findClientByDni(inputDni);

        // Mostrar los resultados
        if (foundClient != null) {
            System.out.println("Cliente encontrado: " + foundClient);
        }

        // Cerrar el escáner
        scanner.close();

        Item item1 = new Item(100,"Botellas", 3, 100);
        List<Item> items= new ArrayList<>();
        items.add(item1);

        Invoice invoice = market.makeInvoice(client3,items);

        System.out.println(invoice);
        */
    }
}