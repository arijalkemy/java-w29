package com.bootcampw29.siniestros_autos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patent;
    private String brand;
    private String model;
    @Column(name = "fabrication_year")
    private Integer fabricationYear;
    @Column(name = "number_of_tires")
    private Integer numberOfTires;
    @OneToMany(mappedBy = "vehicle")
    private List<Accident> accidents;

}
