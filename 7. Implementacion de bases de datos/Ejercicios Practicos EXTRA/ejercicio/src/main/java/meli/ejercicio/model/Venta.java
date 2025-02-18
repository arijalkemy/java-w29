package meli.ejercicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "ventas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    private LocalDateTime fecha;

    private Double total;

    @Column(name = "medio_pago")
    private String medioPago;

    @ManyToMany(mappedBy = "venta", cascade = CascadeType.ALL)
    private Set<Prenda> prendas;
}
