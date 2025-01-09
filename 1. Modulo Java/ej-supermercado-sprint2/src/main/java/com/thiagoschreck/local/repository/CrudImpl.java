package com.thiagoschreck.local.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CrudImpl<T> implements Crud<T> {
    List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void removeItem(T item) {
        items.remove(item);
    }

    public Optional<T> getById(String id) {
        return Optional.empty();
    }
}
