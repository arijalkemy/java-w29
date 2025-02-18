package com.example.ejercicioextra1.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "prendas")
@Data
@Builder
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    @Column(name = "precio_venta")
    private Double precioVenta;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    @ToString.Exclude
    private Venta venta;

}
