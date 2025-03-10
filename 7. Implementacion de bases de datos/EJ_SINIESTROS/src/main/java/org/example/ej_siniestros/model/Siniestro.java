package org.example.ej_siniestros.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // Importa esta clase para evitar la recursión
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int fecha;

    @Column(name = "perdida_economica")
    private Integer perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo", nullable = false, referencedColumnName = "id")
    @JsonBackReference
    private Vehiculo vehiculo;
}