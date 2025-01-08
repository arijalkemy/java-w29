package com.bootcamp;

public class Inscripcion {

    private Integer numero;
    private Participante participante;
    private Categoria categoria;
    private Double montoAAbonar;

    public Inscripcion(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Double getMontoAAbonar() {
        return montoAAbonar;
    }

    public void setMontoAAbonar(Double montoAAbonar) {
        this.montoAAbonar = montoAAbonar;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numero=" + numero +
                ", participante=" + participante +
                ", categoria=" + categoria +
                ", montoAAbonar=" + montoAAbonar +
                '}';
    }
}
