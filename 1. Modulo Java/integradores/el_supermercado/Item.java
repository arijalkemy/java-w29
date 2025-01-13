package com.example.demo.integradores.el_supermercado;

class Item {
    private String code;
    private String name;
    private int quantity;
    private double unitCost;

    public Item(String code, String name, int quantity, double unitCost) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitCost() {
        return unitCost;
    }
}