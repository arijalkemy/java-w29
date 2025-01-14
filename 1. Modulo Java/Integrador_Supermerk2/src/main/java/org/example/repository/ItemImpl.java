package org.example.repository;

import org.example.model.Item;
import java.util.List;
import java.util.Optional;

public class ItemImpl implements CRUD<Item>{

    private List<Item> items;

    @Override
    public void save(Item obj) {
        items.add(obj);
    }

    @Override
    public void show() {
        items.forEach(System.out::println);
    }

    @Override
    public Optional<Item> search(int code) {
        Optional<Item> item = items.stream().filter(i -> i.getCode() == code).findFirst();

        if (item.isPresent()) {
            System.out.println("Item con codigo: " + code + " fue encontrado, sus datos son: /b" +
                    "Nombre: " + item.get().getName() + "/b" +
                    "Costo Unitario: " + item.get().getCostUnit());
            return item;
        }
        else {
            return  Optional.empty();
        }
    }

    @Override
    public void delete(Item obj) {
        items.remove(obj);
    }

    @Override
    public List<Item> all() {
        return items;
    }
}
