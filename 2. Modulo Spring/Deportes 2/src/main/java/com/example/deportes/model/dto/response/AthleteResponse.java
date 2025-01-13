package com.example.deportes.model.dto.response;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AthleteResponse implements Serializable {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
