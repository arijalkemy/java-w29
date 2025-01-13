package com.bootcamp.dto;

public class PersonDto {

    private String personName;
    private String personLastName;
    private String sportName;

    public PersonDto() {
    }

    public PersonDto(String personName, String personLastName, String sportName) {
        this.personName = personName;
        this.personLastName = personLastName;
        this.sportName = sportName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
