package exercise.seguros_autos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "vehiculos")
public class Vehiculo {

    @Id
    private Long id;

    private String patente;
    private String marca;
    private String modelo;

    @Column(name = "anio_fabricacion")
    private Integer anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private List<Siniestro> siniestros;
}
