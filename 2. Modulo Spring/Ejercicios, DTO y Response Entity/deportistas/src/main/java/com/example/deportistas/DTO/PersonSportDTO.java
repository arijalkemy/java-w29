package com.example.deportistas.DTO;

import com.example.deportistas.model.Person;

public class PersonSportDTO {
    private String nombreYApellido;
    private String sport;

    public PersonSportDTO(Person person) {
        this.nombreYApellido = person.getNombre() + " " + person.getApellido();
        this.sport = person.getDeporte().getNombre();
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public PersonSportDTO(String nombreYApellido, String sport) {
        this.nombreYApellido = nombreYApellido;
        this.sport = sport;
    }
}
