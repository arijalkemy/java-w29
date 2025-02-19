package com.example.ejercicioextra1.entity.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ventas")
@Data
@Builder
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fecha;
    private Double total;

    @Column(name = "medio_pago")
    private String medioPago;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "venta")
    @ToString.Exclude
    List<Prenda> prendas;

    public void setPrendas(List<Prenda> prendas) {
        this.prendas = prendas;
        prendas.forEach(prenda -> prenda.setVenta(this));
    }


}
