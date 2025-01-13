package com.meli.scaffolding.models;

public class DeportistaDTO {
    private String nombre;
    private String apellido;
    private String deporte;

    public DeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }

    public DeportistaDTO(Persona persona) {
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.deporte = persona.getDeporte().getNombre();
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

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }
}
