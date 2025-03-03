package org.meli.qatesters.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name = "number_of_tries")
    int numberOfTries;
    @Column(name = "last_update")
    LocalDate lastUpdate;
}
