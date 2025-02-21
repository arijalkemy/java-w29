package com.example.qa_testers.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "feature_id")
    @Column(name = "test_cases")
    List<TestCase> testCases;
}
