package meli.ejercicio.repository;

import meli.ejercicio.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroJpaRepository extends JpaRepository<Siniestro, Long> {
}
