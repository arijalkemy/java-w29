package com.example.qatester.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "tester")
public class Tester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tester")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "tester", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TestCase> tests;
}
