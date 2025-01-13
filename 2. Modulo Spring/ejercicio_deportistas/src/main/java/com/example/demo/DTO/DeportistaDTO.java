package com.example.demo.DTO;

import com.example.demo.model.Persona;

import java.io.Serializable;

//Visualizar a las personas deportistas. Queremos que se vea un listado con el nombre y el apellido de la persona
// y el nombre del deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado).
// Para este punto es importante valerse de un DTO.
//PATH: /findSportsPersons

public class DeportistaDTO implements Serializable {

    private String fullname;
    private String deporteNombre;

    //getters y setters


    public DeportistaDTO(Persona p) {
        this.deporteNombre = p.getDeporte().getNombre();
        this.fullname = p.getNombre() + " " + p.getApellido();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDeporteNombre() {
        return deporteNombre;
    }

    public void setDeporteNombre(String deporteNombre) {
        this.deporteNombre = deporteNombre;
    }
}
