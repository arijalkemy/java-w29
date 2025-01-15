package org.example.model;

import java.util.List;

public class Cliente {

    private String name;
    private List<Localizador> localizadores;

    public Cliente(String name, List<Localizador> localizadores) {
        this.name = name;
        this.localizadores = localizadores;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void addLocalizador(Localizador localizador){
        localizadores.add(localizador);
    }
}
