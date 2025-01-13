package org.example.repository;

import org.example.model.Invoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceImp implements ICRUDRepository<Invoice> {
    List<Invoice> invoices = new ArrayList<>();

    @Override
    public void save(Invoice entity) {
        invoices.add(entity);
    }

    @Override
    public void printAll() {
        invoices.forEach(System.out::println);
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return invoices.stream()
                .filter(invoice -> invoice.getCode().equals(id))
                .findFirst()
                .or(Optional::empty);
    }

    @Override
    public void delete(Long id) {
        invoices.removeIf(invoice -> invoice.getCode().equals(id));
    }

    @Override
    public List<Invoice> findAll() {
        return List.of();
    }
}
