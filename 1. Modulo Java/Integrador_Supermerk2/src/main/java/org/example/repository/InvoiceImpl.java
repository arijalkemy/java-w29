package org.example.repository;

import org.example.model.Invoice;
import java.util.List;
import java.util.Optional;

public class InvoiceImpl implements CRUD<Invoice> {

    private List<Invoice> facturas;

    @Override
    public void save(Invoice obj) {
        facturas.add(obj);
    }

    @Override
    public void show() {
        facturas.forEach(System.out::println);
    }

    @Override
    public Optional<Invoice> search(int id) {
        Optional<Invoice> invoice = facturas.stream().filter(f -> f.getId() == id).findFirst();

        if (invoice.isPresent()) {
            System.out.println("Facttura con id: " + id + " fue encontrada, sus datos son: /b" +
                    "Cliente: " + invoice.get().getClient().getName() + "/b" +
                    "Total: " + invoice.get().getTotal());
            return invoice;
        }
        else {
            return  Optional.empty();
        }
    }

    @Override
    public void delete(Invoice obj) {
        facturas.remove(obj);
    }

    @Override
    public List<Invoice> all() {
        return facturas;
    }
}
