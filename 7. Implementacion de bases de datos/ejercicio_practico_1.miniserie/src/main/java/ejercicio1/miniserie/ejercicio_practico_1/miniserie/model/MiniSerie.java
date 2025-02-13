package ejercicio1.miniserie.ejercicio_practico_1.miniserie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "miniserie")

public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double rating;

    @Column(name = "amount")
    private int amount_of_awards;
}
