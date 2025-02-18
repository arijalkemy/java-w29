package com.example.Seguros_Autos.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter@Setter
public class SiniestroDTO {
    private Long idSiniestro;
    private Date fechaSiniestro;
    private Double perdidaEconomica;

    public SiniestroDTO() {}

    public SiniestroDTO(Long idSiniestro, Date fechaSiniestro, Double perdidaEconomica, Long idVehiculoDenunciado) {
        this.idSiniestro = idSiniestro;
        this.fechaSiniestro = fechaSiniestro;
        this.perdidaEconomica = perdidaEconomica;
}
}


