package org.example.ej_siniestros.model;

import com.fasterxml.jackson.annotation.JsonManagedReference; // Importa esta clase para manejar la serialización
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;

    private String marca;

    private String modelo;

    @Column(name = "anio")
    private int anio;

    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Siniestro> siniestros;
}