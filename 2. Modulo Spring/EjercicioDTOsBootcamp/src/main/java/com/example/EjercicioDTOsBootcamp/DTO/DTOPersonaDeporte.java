package com.example.EjercicioDTOsBootcamp.DTO;

public class DTOPersonaDeporte {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public DTOPersonaDeporte(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    @Override
    public String toString() {
        return "DTOPersonaDeporte{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", nombreDeporte='" + nombreDeporte + '\'' +
                '}';
    }
}
