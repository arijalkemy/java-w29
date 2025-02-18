package paso_a_paso.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TestCase {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id_case;
  String description;
  Boolean tested;
  Boolean passed;
  Integer number_of_tries;
  LocalDate last_update;
}

