package com.bootcamp;

import java.util.HashSet;
import java.util.Set;

public class Categoria {

    private String circuito;
    private Float km;
    private String descripcion;
    private Set<Participante> participantes;


    public static final String CIRCUITO_CHICO = "CHICO";
    public static final String CIRCUITO_MEDIO = "MEDIO";
    public static final String CIRCUITO_AVANZADO = "AVANZADO";

    public Categoria(String circuito) {
        this.circuito = circuito;
        participantes = new HashSet<Participante>();
    }

    public String getCircuito() {
        return circuito;
    }

    public Float getKm() {
        return km;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public void setKm(Float km) {
        this.km = km;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Set<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Set<Participante> participantes) {
        this.participantes = participantes;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "circuito='" + circuito + '\'' +
                ", km=" + km +
                ", descripcion='" + descripcion + '\'' +
                ", participantes=" + participantes +
                '}';
    }
}
