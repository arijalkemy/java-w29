package meli.ejercicio.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "miniserie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double rating;

    @Column(name = "amount_of_awards")
    private Integer awards;
}
