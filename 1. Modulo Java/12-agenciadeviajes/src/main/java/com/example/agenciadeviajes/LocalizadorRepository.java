package com.example.agenciadeviajes;

import java.util.List;
import java.util.Map;

public class LocalizadorRepository {
    private Map<String, List<Localizador>> localizadores;

    public LocalizadorRepository(Map<String, List<Localizador>> locators) {
        this.localizadores = locators;
    }

    public List<Localizador> getLocalizador(String id) {
        return this.localizadores.get(id);
    }

    public void setLocalizadores(Map<String, List<Localizador>> localizadores) {
        this.localizadores = localizadores;
    }

    public int getLocalizadoresVendidos(){
        return this.localizadores.values().stream().mapToInt(List::size).sum();
    }

    /*
     " 1 " , Locators[] = { getReservations }
     */
    public int getCantidadReservas(){
        return this.localizadores.values().stream()
                .flatMapToInt(l -> l.stream().mapToInt( (a) -> a.getReservations().size()))
                .sum();
    }
}
