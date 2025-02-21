package com.example.qa_testers.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "test_case")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    Long idCase;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name = "number_of_tries")
    Integer numberOfTries;
    @Column(name = "last_update")
    LocalDate lastUpdate;
    @ManyToOne
    @JoinColumn(name = "feature_id", nullable = false)
    Feature feature;
}
