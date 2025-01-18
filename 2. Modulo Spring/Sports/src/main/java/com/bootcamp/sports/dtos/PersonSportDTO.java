package com.bootcamp.sports.dtos;

import com.bootcamp.sports.models.Person;
import com.bootcamp.sports.models.Sport;
import lombok.Data;

@Data
public class PersonSportDTO {
    private String firstname;
    private String lastname;
    private String sportname;

    public PersonSportDTO(Person person, Sport sport) {
        this.firstname = person.getFirstname();
        this.lastname = person.getLastname();
        this.sportname = sport.getName();
    }

    public PersonSportDTO() {}

}


