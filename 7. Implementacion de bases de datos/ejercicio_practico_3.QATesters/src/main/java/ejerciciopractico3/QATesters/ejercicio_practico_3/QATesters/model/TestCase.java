package ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
@Entity
@Table(name = "testcase")
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @Column(name = "number_of_tries")
    private int numberOfTries;
    @Column(name = "last_update")
    private Date lastUpdate;

    public TestCase() {
    }

    public TestCase(Long idCase, String description, Boolean tested, Boolean passed, int numberOfTries, Date lastUpdate) {
        this.idCase = idCase;
        this.description = description;
        this.tested = tested;
        this.passed = passed;
        this.numberOfTries = numberOfTries;
        this.lastUpdate = lastUpdate;
    }

}
