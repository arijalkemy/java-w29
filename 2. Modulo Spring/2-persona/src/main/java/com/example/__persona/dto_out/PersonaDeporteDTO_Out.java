package com.example.__persona.dto_out;

import com.example.__persona.model.Persona;

public class PersonaDeporteDTO_Out {
    private String nombreApellido;
    private String deporte;

    public PersonaDeporteDTO_Out(Persona p) {
        this.nombreApellido = p.getNombre() + " " + p.getApellido();
        this.deporte = p.getDeporte().getNombre();
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public String getDeporte() {
        return deporte;
    }
}
