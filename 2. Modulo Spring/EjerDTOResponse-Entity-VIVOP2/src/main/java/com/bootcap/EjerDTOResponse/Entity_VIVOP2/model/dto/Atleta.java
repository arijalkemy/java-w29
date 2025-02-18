package com.bootcap.EjerDTOResponse.Entity_VIVOP2.model.dto;

import com.bootcap.EjerDTOResponse.Entity_VIVOP2.model.Deporte;

public class Atleta {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    public Atleta(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }
}
