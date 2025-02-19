package com.meli.Showroom.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    private LocalDate fecha;
    private Double total;
    @Column(name = "medio_de_pago")
    private String medioDePago;

    @ManyToMany
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "prenda_id")
    )
    @JsonManagedReference
    private List<Prenda> prendas;
}
