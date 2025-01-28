package org.example.repositiry;

import org.example.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository <Factura> {

    List <Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void save(Factura object) {
        listaFacturas.add(object);
    }

    @Override
    public void mostrarPantalla() {
        for (Factura fact : listaFacturas) {
            System.out.println(fact.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {
        boolean bandera = false;
        for (Factura f : listaFacturas) {
            if (f.getCodigo().equals(codigoBuscado)) {
                System.out.println("------------- Factura encontrada, sus datos son: ---------");
                System.out.println(f.toString());
                return Optional.of(f);
            }
        }

        if (bandera==false) {
            System.out.println("La factura no se ha encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoBorrado) {
        Optional<Factura> fact = this.buscar(codigoBorrado);

        if (fact.isEmpty()) {
            System.out.println("La factura a eliminar no existe");
        }else {
            System.out.println("La factura se a eliminado");
            listaFacturas.remove(fact.get());
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return listaFacturas;
    }
}
