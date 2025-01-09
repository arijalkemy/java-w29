package com.thiagoschreck.local.repository;

import java.util.List;

public interface Crud <T> {
    void addItem(T item);
    List<T> getItems();
    void setItems(List<T> items);
    void removeItem(T item);
}
