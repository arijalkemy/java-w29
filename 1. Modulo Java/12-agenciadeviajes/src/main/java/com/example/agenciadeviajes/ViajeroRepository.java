package com.example.agenciadeviajes;

import java.util.HashMap;
import java.util.Map;

public class ViajeroRepository {
    private Map<Long, Viajero> viajeros;

    public ViajeroRepository() {
        this.viajeros = new HashMap<>();
    }

    public Viajero getViajero(String id) {
        return viajeros.get(id);
    }

    public void addViajero(Viajero viajero) {
        viajeros.put(viajero.getId(), viajero);
    }

    public boolean exists(String id) {
        return viajeros.containsKey(id);
    }
}
