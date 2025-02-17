package hql.hqlmovies.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "patente")
    private String patent;

    @Column(name = "marca")
    private String brand;

    @Column(name = "modelo")
    private String model;

    @Column(name = "agno_fabricacion")
    private Integer yearFabricated;

    @Column(name = "cantidad_ruedas")
    private Integer cantidadDeRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Siniestro> siniestros;
}