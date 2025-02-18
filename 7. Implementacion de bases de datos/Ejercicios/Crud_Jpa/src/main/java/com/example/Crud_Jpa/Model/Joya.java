package com.example.Crud_Jpa.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Joyas")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONO;


    public Joya(Long nroIdentificatorio, String nombre, String material, Double peso, String particularidad, Boolean posee_piedra, Boolean ventaONO) {
        this.nroIdentificatorio = nroIdentificatorio;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.ventaONO = ventaONO;
    }

    public Joya(String nombre, String material, Double peso, String particularidad, Boolean posee_piedra, Boolean ventaONO) {
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.posee_piedra = posee_piedra;
        this.ventaONO = ventaONO;
    }

    public Joya() {
    }

    public Long getNroIdentificatorio() {
        return nroIdentificatorio;
    }

    public void setNroIdentificatorio(Long nroIdentificatorio) {
        this.nroIdentificatorio = nroIdentificatorio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getParticularidad() {
        return particularidad;
    }

    public void setParticularidad(String particularidad) {
        this.particularidad = particularidad;
    }

    public Boolean getPosee_piedra() {
        return posee_piedra;
    }

    public void setPosee_piedra(Boolean posee_piedra) {
        this.posee_piedra = posee_piedra;
    }

    public Boolean getVentaONO() {
        return ventaONO;
    }

    public void setVentaONO(Boolean ventaONO) {
        this.ventaONO = ventaONO;
    }

    @Override
    public String toString() {
        return "Joya{" +
                "nro_identificatorio=" + nroIdentificatorio +
                ", nombre='" + nombre + '\'' +
                ", material='" + material + '\'' +
                ", peso=" + peso +
                ", particularidad='" + particularidad + '\'' +
                ", posee_piedra=" + posee_piedra +
                ", ventaONO=" + ventaONO +
                '}';
    }
}
