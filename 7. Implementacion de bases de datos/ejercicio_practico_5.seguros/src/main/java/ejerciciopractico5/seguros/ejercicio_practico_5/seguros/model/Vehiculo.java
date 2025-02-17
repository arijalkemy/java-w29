package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private Integer año;
    @Column(name = "cant_ruedas")
    private Integer cantRuedad;
    private String marca;
    private String modelo;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehiculo_id")
    private List<Sinietro> sinietros;

    public Vehiculo(Long id, Integer ano, Integer cantRuedad, String marca, String modelo ,String patente) {
        this.id = id;
        this.patente = patente;
        this.año = ano;
        this.cantRuedad = cantRuedad;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Vehiculo() {
    }
}
