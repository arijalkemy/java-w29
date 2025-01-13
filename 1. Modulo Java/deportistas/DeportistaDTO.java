package com.example.demo.deportistas;

import lombok.Setter;

import java.io.Serializable;

public class DeportistaDTO implements Serializable {
    private String nombre;
    @Setter
    private String apellido;
    private String deporte;

    public DeportistaDTO(String nombre, String apellido, String deporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.deporte = deporte;
    }
    public DeportistaDTO() {

    }
    public String getNombre() {
        return nombre;
    }
    //
    public String getApellido() {
        return apellido;
    }

    public String getDeporte() {
        return deporte;
    }
}
