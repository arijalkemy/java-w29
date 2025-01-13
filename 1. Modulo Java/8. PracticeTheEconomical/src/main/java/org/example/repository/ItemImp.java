package org.example.repository;

import org.example.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements ICRUDRepository<Item> {
    List<Item> items = new ArrayList<>();

    @Override
    public void save(Item item) {
        items.add(item);
    }

    @Override
    public void printAll() {
        items.forEach(System.out::println);
    }

    @Override
    public Optional<Item> findById(Long id) {
        return items.stream()
                .filter(item -> item.getCode().equals(id))
                .findFirst()
                .or(Optional::empty);
    }

    @Override
    public void delete(Long id) {
        items.removeIf(item -> item.getCode().equals(id));
    }

    @Override
    public List<Item> findAll() {
        return List.of();
    }
}
