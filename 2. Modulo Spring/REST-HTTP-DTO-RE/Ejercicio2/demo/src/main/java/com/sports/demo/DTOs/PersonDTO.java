package com.sports.demo.DTOs;

import lombok.Data;

@Data
public class PersonDTO {
    private String fullname;
    private String sportname;
    
    public PersonDTO(String name, String surname, String sportname) {
        this.fullname = name + " " + surname;
        this.sportname = sportname;
    }
}
