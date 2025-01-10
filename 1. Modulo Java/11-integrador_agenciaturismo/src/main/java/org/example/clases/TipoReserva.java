package org.example.clases;

public class TipoReserva {
    private Integer id;
    private String nombre;

    //constructor

    public TipoReserva(String nombre, Integer id) {
        this.nombre = nombre;
        this.id = id;
    }

    //getters y setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //to string

    @Override
    public String toString() {
        return "TipoReserva{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
