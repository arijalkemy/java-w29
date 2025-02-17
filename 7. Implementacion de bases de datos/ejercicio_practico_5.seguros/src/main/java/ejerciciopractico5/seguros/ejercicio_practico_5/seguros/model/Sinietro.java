package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "siniestro")
public class Sinietro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    @Column(name = "perdida_economica")
    private Double perdida;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false, referencedColumnName = "id")
    private Vehiculo vehiculo;
}
