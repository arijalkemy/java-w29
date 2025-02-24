package com.example.demo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class CompraKey implements Serializable {
    private Integer idPersona;
    private LocalDate fecha;

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CompraKey compraKey = (CompraKey) o;
        return Objects.equals(idPersona, compraKey.idPersona) && Objects.equals(fecha, compraKey.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersona, fecha);
    }
}
