package com.bootcamp.dto_p2.dto;

import com.bootcamp.dto_p2.model.Person;
import lombok.Data;

@Data
public class PersonDTO {
    private String name;
    private String lastName;
    private String sportName;

    public PersonDTO(Person person) {
        this.name = person.getName();
        this.lastName = person.getLastName();
        this.sportName = person.getSport().getName();
    }
}
