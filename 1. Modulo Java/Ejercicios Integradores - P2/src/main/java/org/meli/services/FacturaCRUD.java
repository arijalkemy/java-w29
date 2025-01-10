package org.meli.services;

import org.meli.interfaces.CRUD;
import org.meli.models.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaCRUD implements CRUD<Factura> {
    private List<Factura> facturas = new ArrayList<>();

    @Override
    public void create(Factura factura) {
        facturas.add(factura);
    }

    @Override
    public Optional<Factura> read(String id) {
        return facturas.stream().filter(factura -> factura.getId().equals(id)).findFirst();
    }

    @Override
    public void update(Factura factura) {
        delete(factura.getId());
        create(factura);
    }

    @Override
    public void delete(String id) {
        facturas.removeIf(factura -> factura.getId().equals(id));
    }
}
