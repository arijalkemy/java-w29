package com.example.testers.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "test_cases")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @JsonProperty("id_case")
    @Column(name = "id_case")
    private Long id;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @Column(name = "number_of_tries")
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    @Column(name = "last_update")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lastUpdate;
}
