package org.example;

public class Descuento {
    private String porcentaje;
    private String descripcion;


    public Descuento() {
    }

    public Descuento(String porcentaje, String descripcion) {
        this.porcentaje = porcentaje;
        this.descripcion = descripcion;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "\nDescuento{" +
                "porcentaje='" + porcentaje + "%" +'\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
