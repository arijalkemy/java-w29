package com.thiagoschreck.local.model;

public record Prenda(String marca, String modelo) {

    @Override
    public String toString() {
        return String.format("%s %s", marca, modelo);
    }
}
