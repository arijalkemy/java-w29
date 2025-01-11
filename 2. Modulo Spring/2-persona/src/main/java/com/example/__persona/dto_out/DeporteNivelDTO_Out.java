package com.example.__persona.dto_out;

import com.example.__persona.model.Deporte;

public class DeporteNivelDTO_Out {
    private String nombre;
    private Integer nivel;

    public DeporteNivelDTO_Out(Deporte d) {
        this.nombre = d.getNombre();
        this.nivel = d.getNivel();
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivel() {
        return nivel;
    }
}
