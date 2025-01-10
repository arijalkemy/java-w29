package org.example.repository;

import org.example.clases.Factura;
import org.example.clases.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements  CRUDInterfaz<Item> {

    List<Item> itemList = new ArrayList<Item>();
    @Override
    public void save(Item item) {
        itemList.add(item);

    }

    @Override
    public void mostrarPorPantalla() {
        System.out.println("----- Mostrar todos los items por pantalla -----");
        for (Item item : itemList) {
            System.out.println(item.toString());
        }

    }

    @Override
    public Optional<Item> buscarPorDni(String dni) {
        return Optional.empty();
    }

    @Override
    public Optional<Item> buscarPorID(Integer id) {
        Boolean itemBandera = false;
        for (Item item : itemList) {
            if (item.getId().equals(id)) {
                System.out.println(item.toString());
                itemBandera = true;  // Se encontró el cliente
                return Optional.of(item);
            }
        }

        // Si no se encontró el cliente
        if (!itemBandera) {
            System.out.println("El item con ID " +id + " no existe.");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Integer id) {
        Optional<Item> itemEncontrado = buscarPorID(id);
        if (itemEncontrado.isEmpty()) {
            System.out.println("No se encontro el item a borrar");
        }else{
            itemList.remove(itemEncontrado.get());
            System.out.println("El item se eliminado correctamente");
        }

    }

    @Override
    public List<Item> trearTodos() {
        return itemList;
    }
}
