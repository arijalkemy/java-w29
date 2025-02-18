package com.example.Seguros_Autos.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class VehiculoDTO {
        private Long idVehiculo;
        private String Patente;
        private String Marca;
        private String Modelo;
        private Integer AnioFabricacion;
        @JsonProperty("cantidad_de_ruedas")
        private Integer CantidadDeRuedas;

    public VehiculoDTO() {}

    public VehiculoDTO(String Patente, String Marca, String Modelo, Integer AnioFabricacion, Integer CantidadDeRuedas) {
        this.Patente = Patente;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.AnioFabricacion = AnioFabricacion;
        this.CantidadDeRuedas = CantidadDeRuedas;
    }
}
