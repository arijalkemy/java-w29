package meli.ejercicio.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "test_case")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long id;

    private String description;

    private Boolean tested;

    private Boolean passed;

    @Column(name = "number_of_tries")
    private int numberOfTries;

    @Column(name = "last_update")
    private LocalDate lastUpdate;

    public TestCase(String description, Boolean tested, Boolean passed, int numberOfTries, LocalDate lastUpdate) {
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }
}
