package meli.ejercicio.repository;

import meli.ejercicio.model.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestCaseJpaRepository extends JpaRepository<TestCase, Long> {
}
