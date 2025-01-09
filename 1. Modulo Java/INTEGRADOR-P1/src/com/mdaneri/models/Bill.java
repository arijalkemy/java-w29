package com.mdaneri.models;

import java.util.List;

public class Bill {

    private List<Item> items;
    private Double totalCost;

    public void addItem(Item i) {
        items.add(i);
        totalCost += i.getPrice() * i.getAmount();
    }

    public void removeItem(Item i) {
        items.remove(i);
        totalCost -= i.getPrice() * i.getAmount();
    }

}
