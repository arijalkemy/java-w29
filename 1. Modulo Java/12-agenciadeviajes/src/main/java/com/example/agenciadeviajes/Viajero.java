package com.example.agenciadeviajes;

import java.util.ArrayList;
import java.util.List;

public class Viajero {
    private Long id;
    private String nombre;
    private List<Localizador> localizadores;
    private Boolean tieneDescuento;

    public Viajero(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
        this.tieneDescuento = false;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public Boolean getTieneDescuento() {
        return tieneDescuento;
    }

    public void descuentoEnFalso(){
        this.tieneDescuento = false;
    }

    public void agregarLocalizador(Localizador localizador){
        this.localizadores.add(localizador);
        if(this.localizadores.size() >= 2){
            this.tieneDescuento = true;
        }
    }
}
