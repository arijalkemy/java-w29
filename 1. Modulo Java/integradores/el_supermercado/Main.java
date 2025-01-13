package com.example.demo.integradores.el_supermercado;

import com.example.demo.integradores.el_supermercado.CRUD.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomerRepository customerRepository = new CustomerRepository();
        List<Invoice> invoices = new ArrayList<>();

        customerRepository.create(new Customer("44690195", "Eliseo", "Sanz"));
        customerRepository.create(new Customer("17466613", "Enrique", "Sanz"));
        customerRepository.create(new Customer("16386399", "Mabel", "Arellano"));

        Customer customer = customerRepository.read("44690195")
                .orElseGet(() -> {
                    Customer newCustomer = new Customer("44690195", "Eliseo", "Sanz");
                    customerRepository.create(newCustomer);
                    return newCustomer;
                });

        List<Item> items = List.of(
                new Item("A", "Atún", 20, 300),
                new Item("B", "Boldo", 20, 300),
                new Item("C", "Cajon", 20, 300),
                new Item("D", "Dátiles", 20, 300)
        );
        Invoice invoice = new Invoice(customer, items);
        invoices.add(invoice);
        invoice.printDetails();
        addAnotherInvoice(customerRepository, invoices);
        listAllCustomers(customerRepository);
    }

    private static void listAllCustomers(CustomerRepository customerRepository) {
        System.out.println("\nTodos los clientes:");
        customerRepository.listAll().forEach(customer ->
                System.out.println(customer.getDni() + " - " + customer.getFirstName()));
    }

    private static void addAnotherInvoice(CustomerRepository customerRepository, List<Invoice> invoices) {
        Customer customer = customerRepository.read("87654321B")
                .orElseGet(() -> {
                    Customer newCustomer = new Customer("7724909", "Rosa", "Prudencia");
                    customerRepository.create(newCustomer);
                    return newCustomer;
                });

        List<Item> items = List.of(
                new Item("004", "Queso", 1, 4.50),
                new Item("005", "Dulce", 1, 3.20)
        );

        Invoice invoice = new Invoice(customer, items);
        invoices.add(invoice);
        System.out.println("\nNueva factura:");
        invoice.printDetails();
    }
}