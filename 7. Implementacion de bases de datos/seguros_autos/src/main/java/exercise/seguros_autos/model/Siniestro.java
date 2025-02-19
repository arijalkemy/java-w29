package exercise.seguros_autos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "siniestros")
public class Siniestro {

    @Id
    private Long id;

    private LocalDate fecha;

    @Column(name = "perdida_economica")
    private Double perdidaEconomica;
}
