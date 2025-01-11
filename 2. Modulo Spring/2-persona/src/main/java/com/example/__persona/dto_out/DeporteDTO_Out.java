package com.example.__persona.dto_out;

import com.example.__persona.model.Deporte;

public class DeporteDTO_Out {
    private String nombre;

    public DeporteDTO_Out(Deporte deporte) {
        this.nombre = deporte.getNombre();
    }

    public String getNombre() {
        return nombre;
    }
}
