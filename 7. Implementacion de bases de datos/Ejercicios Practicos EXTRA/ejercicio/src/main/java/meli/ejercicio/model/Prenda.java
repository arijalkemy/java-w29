package meli.ejercicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "prendas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombre;

    private String tipo;

    private String marca;

    private String color;

    private Integer talle;

    private Integer cantidad;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @ManyToMany
    @JoinTable(name = "ventas_prendas",
            joinColumns = @JoinColumn(name = "prenda_codigo"),
            inverseJoinColumns = @JoinColumn(name = "venta_numero"))
    private Set<Venta> venta;
}
