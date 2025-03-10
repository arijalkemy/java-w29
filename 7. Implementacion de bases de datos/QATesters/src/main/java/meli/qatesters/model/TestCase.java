package meli.qatesters.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
@Table(name = "tests_cases")
public class TestCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    Long id;
    String description;
    Boolean tested;
    Boolean passed;
    @Column(name = "number_of_tries")
    Integer number_of_tries;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "last_update")
    private LocalDate lastUpdate;
}
