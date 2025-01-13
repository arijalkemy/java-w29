package com.example.demo.integradores.agencia_turismo;

import java.util.ArrayList;
import java.util.List;

class Client {
    private String id;
    private String name;
    private List<Locator> locators;

    private boolean hasDiscount; // donde puede ir

    public Client(String id, String name) {
        this.id = id;
        this.name = name;
        this.locators = new ArrayList<>();
        this.hasDiscount = false; // Inicialmente no tiene descuento

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Locator> getLocators() {
        return locators;
    }

    public boolean hasDiscount() {
        return hasDiscount;
    }

    public void resetDiscount() {
        hasDiscount = false; // Se reinicia despues de aplicar el descuento
    }

    public void addLocator(Locator locator) {
        this.locators.add(locator);
        if (locators.size() >= 2) hasDiscount = true;
    }

}
