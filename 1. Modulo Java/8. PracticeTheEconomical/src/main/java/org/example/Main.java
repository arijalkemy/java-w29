package org.example;

import org.example.model.Client;
import org.example.model.Invoice;
import org.example.model.Item;
import org.example.repository.ClientImp;
import org.example.repository.InvoiceImp;
import org.example.repository.ItemImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClientImp clientImp = new ClientImp();
        ItemImp itemImp = new ItemImp();
        InvoiceImp invoiceImp = new InvoiceImp();
        Scanner scanner = new Scanner(System.in);
        String dni;

        clientImp.save(new Client(123456L, "Nombre1", "Apellido1"));
        clientImp.save(new Client(456789L, "Nombre2", "Apellido2"));
        clientImp.save(new Client(789987L, "Nombre3", "Apellido3"));

        clientImp.printAll();
        System.out.println("=====================");

        clientImp.delete(123456L);
        System.out.println("=====================");

        System.out.println("Ingrese un DNI");
        dni = scanner.next();

        Optional<Client> result = clientImp.findById(Long.parseLong(dni));
        System.out.println(result.isPresent() ? result.toString() : "No se encontró un cliente con ese dni");

        System.out.println("Ingrese el dni del cliente de la factura");
        dni = scanner.next();
        Client client = clientImp.findById(Long.parseLong(dni)).orElse(null);

        if (client == null) {
            System.out.println("Cliente no encontrado ingrese la siguiente informacion");
            System.out.println("DNI Nombre Apellido");
            client = new Client(scanner.nextLong(), scanner.next(), scanner.next());
            clientImp.save(client);
        }

        itemImp.save(new Item(1L, "Pollo", 2, 20000));
        itemImp.save(new Item(2L, "Arrroz", 4, 10000));
        itemImp.save(new Item(3L, "Pasta", 1, 1000));
        itemImp.save(new Item(4L, "Atún", 4, 15000));
        itemImp.save(new Item(5L, "Carne", 3, 30000));

        Invoice invoice = new Invoice(1L, client, itemImp.findAll());
        invoiceImp.save(invoice);
        System.out.println("=====================");
        System.out.println(invoice);
    }
}