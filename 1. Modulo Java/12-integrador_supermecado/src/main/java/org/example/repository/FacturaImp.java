package org.example.repository;

import org.example.clases.Cliente;
import org.example.clases.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements  CRUDInterfaz<Factura>{
    List<Factura> facturaslist = new ArrayList<Factura>();
    @Override
    public void save(Factura factura) {
        facturaslist.add(factura);

    }

    @Override
    public void mostrarPorPantalla() {
        System.out.println("----- Mostrar todas las facturas -----");
        for (Factura factura : facturaslist) {
            System.out.println(factura.toString());
        }


    }

    @Override
    public Optional<Factura> buscarPorDni(String dni) {
        return Optional.empty();
    }

    @Override
    public Optional<Factura> buscarPorID(Integer id) {
        Boolean factoraBandera = false;
        for (Factura factura : facturaslist) {
            if (factura.getId().equals(id)) {
                System.out.println(factura.toString());
                factoraBandera = true;  // Se encontró el cliente
                return Optional.of(factura);
            }
        }

        // Si no se encontró el cliente
        if (!factoraBandera) {
            System.out.println("La factura con ID " +id + " no existe.");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Factura> facturaEncontrada = buscarPorID(id);
        if (facturaEncontrada.isEmpty()) {
            System.out.println("No se encontro la factura a borrar");
        }else{
            facturaslist.remove(facturaEncontrada.get());
            System.out.println("La factura se eliminado correctamente");
        }

    }

    @Override
    public List<Factura> trearTodos() {
        return facturaslist;
    }
}
