package org.example;

import org.example.model.Client;
import org.example.model.Invoice;
import org.example.model.Item;
//import org.example.model.Supermarket;
import org.example.repository.ClientImpl;
import org.example.repository.InvoiceImpl;
import org.example.repository.ItemImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main_parte_2 {
    public static void main(String[] args) {

        //Genero los clientes
        Client client1 = new Client(35949747, "Carolina", "Altamiranda");
        Client client2 = new Client(35949748, "Florencia", "Markov");
        Client client3 = new Client(35949749, "Micaela", "Markov");

        //Genero Items
        Item item = new Item(0001,"Botella", 2,1000);

        ClientImpl repoClient = new ClientImpl();
        InvoiceImpl repoInvoice = new InvoiceImpl();
        ItemImpl repoItems = new ItemImpl();

        repoClient.save(client1);
        repoClient.save(client2);
        repoClient.save(client3);

        repoClient.show();

        repoClient.delete(client1);
        repoClient.show();

        // Solicitar DNI al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número de DNI del cliente:");
        int inputDni = scanner.nextInt();

        // Buscar el cliente por DNI
        repoClient.search(inputDni);

        // Cerrar el escáner
        scanner.close();

    }
}