package com.example.demo.integradores.el_supermercado.CRUD;


import com.example.demo.integradores.el_supermercado.Customer;

import java.util.*;

public class CustomerRepository implements CRUD<Customer> {
    private final Map<String, Customer> customers = new HashMap<>();

    @Override
    public void create(Customer customer) {
        customers.put(customer.getDni(), customer);
    }

    @Override
    public Optional<Customer> read(String dni) {
        return Optional.ofNullable(customers.get(dni));
    }

    @Override
    public void update(String dni, Customer updatedCustomer) {
        customers.put(dni, updatedCustomer);
    }

    @Override
    public void delete(String dni) {
        customers.remove(dni);
    }

    @Override
    public List<Customer> listAll() {
        return new ArrayList<>(customers.values());
    }
}
