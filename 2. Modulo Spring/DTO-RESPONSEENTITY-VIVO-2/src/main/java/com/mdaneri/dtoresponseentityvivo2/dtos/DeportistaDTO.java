package com.mdaneri.dtoresponseentityvivo2.dtos;

import com.mdaneri.dtoresponseentityvivo2.models.Deporte;
import com.mdaneri.dtoresponseentityvivo2.models.Persona;

import java.io.Serializable;

public class DeportistaDTO implements Serializable {

    private Persona persona;
    private Deporte deporte;

    public DeportistaDTO(Persona persona, Deporte deporte) {
        this.persona = persona;
        this.deporte = deporte;
    }

    public Persona getPersona() {
        return persona;
    }

    public Deporte getDeporte() {
        return deporte;
    }
}
