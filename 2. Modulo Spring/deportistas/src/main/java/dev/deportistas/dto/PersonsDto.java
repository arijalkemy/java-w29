package dev.deportistas.dto;

public class PersonsDto {
    private String name;
    private String lastname;
    private String sport;

    public PersonsDto(String name, String lastname, String sport) {
        this.name = name;
        this.lastname = lastname;
        this.sport = sport;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSport(){return sport;}

    public void setSport(String sport){this.sport = sport;}
}
