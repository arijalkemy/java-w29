package com.mdaneri.dtoresponseentityvivo2.dtos;

import com.mdaneri.dtoresponseentityvivo2.models.Deporte;
import com.mdaneri.dtoresponseentityvivo2.models.Persona;

import java.io.Serializable;

public class DeportistaDTO implements Serializable {

    private String firstname;
    private String lastname;
    private String sportname;

    public DeportistaDTO(String firstname, String lastname, String sportname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.sportname = sportname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSportname() {
        return sportname;
    }
}
