package com.example.HQL.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class VehiculoDTO {
    private String patente;
    private String marca;
    private String modelo;
    private int anoFabricacion;
    private int cantidadRuedas;
}

