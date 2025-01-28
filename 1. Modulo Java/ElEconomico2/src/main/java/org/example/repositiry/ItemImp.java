package org.example.repositiry;

import org.example.model.Factura;
import org.example.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository<Item> {

    List <Item> listaItems = new ArrayList<Item>();

    @Override
    public void save(Item object) {
        listaItems.add(object);
    }

    @Override
    public void mostrarPantalla() {
        for (Item item : listaItems) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Optional<Item> buscar(Long codigoBuscado) {
        boolean bandera = false;
        for (Item i : listaItems) {
            if (i.getCodigo().equals(codigoBuscado)) {
                System.out.println("------------- Item encontrado, sus datos son: ---------");
                System.out.println(i.toString());
                return Optional.of(i);
            }
        }

        if (bandera==false) {
            System.out.println("El item no se ha encontrado");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoBorrado) {
        Optional<Item> item = this.buscar(codigoBorrado);

        if (item.isEmpty()) {
            System.out.println("La factura a eliminar no existe");
        }else {
            System.out.println("La factura se a eliminado");
            listaItems.remove(item.get());
        }
    }

    @Override
    public List<Item> traerTodos() {
        return List.copyOf(listaItems);
    }
}
