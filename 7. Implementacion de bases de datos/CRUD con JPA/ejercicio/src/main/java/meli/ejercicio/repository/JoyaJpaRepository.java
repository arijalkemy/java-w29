package meli.ejercicio.repository;

import meli.ejercicio.model.Joya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoyaJpaRepository extends JpaRepository<Joya, Long> {
}
