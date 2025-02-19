package com.meli.Showroom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prenda")
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talla;
    private Integer cantidad;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @ManyToMany(mappedBy = "prendas")
            @JsonBackReference
    List<Venta> ventas;

    public Prenda(Integer codigo, String nombre, String tipo, String marca, String color, String talla, Integer cantidad, Double precioVenta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.marca = marca;
        this.color = color;
        this.talla = talla;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
    }
}
