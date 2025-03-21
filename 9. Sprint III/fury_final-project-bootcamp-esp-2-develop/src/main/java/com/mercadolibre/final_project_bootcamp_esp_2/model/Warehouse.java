package com.mercadolibre.final_project_bootcamp_esp_2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne
    @JoinColumn(name = "supervisor_id", referencedColumnName = "id")
    private User supervisor;

    @OneToMany(mappedBy = "warehouse")
    private List<Sector> sectors;
}