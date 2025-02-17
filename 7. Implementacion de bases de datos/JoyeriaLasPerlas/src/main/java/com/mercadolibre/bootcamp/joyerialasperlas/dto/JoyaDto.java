package com.mercadolibre.bootcamp.joyerialasperlas.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.bootcamp.joyerialasperlas.model.Joya;

public class JoyaDto {

    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;

    @JsonProperty("posee_piedra")
    private Boolean poseePiedra;

    @JsonProperty("ventaONo")
    private Boolean venta;

    public JoyaDto(String nombre, String material, Integer peso, String particularidad, Boolean poseePiedra, Boolean venta) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = poseePiedra;
        this.venta = venta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMaterial() {
        return material;
    }

    public Integer getPeso() {
        return peso;
    }

    public String getParticularidad() {
        return particularidad;
    }

    public Boolean getPoseePiedra() {
        return poseePiedra;
    }

    public Boolean getVenta() {
        return venta;
    }

    public static Joya to(JoyaDto dto) {
        return new Joya(
                dto.getNombre(),
                dto.getMaterial(),
                dto.getPeso(),
                dto.getParticularidad(),
                dto.getPoseePiedra(),
                dto.getVenta()
        );
    }

    public static JoyaDto from(Joya j) {
        return new JoyaDto(
                j.getNombre(),
                j.getMaterial(),
                j.getPeso(),
                j.getParticularidad(),
                j.getPoseePiedra(),
                j.getVenta()
        );
    }

}
