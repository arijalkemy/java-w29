package com.bootcamp.deportista.dto;

import com.bootcamp.deportista.domain.Person;
import com.bootcamp.deportista.domain.Sport;

;
public class DeportistaDTO {
    private String fullName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    private String sport;
    public DeportistaDTO(Person person, Sport sport){
        this.fullName = String.format("%s %s", person.getName(), person.getLastname());
        this.sport = sport.getName();
    }
}
