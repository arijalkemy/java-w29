package meli.ejercicio.repository;

import meli.ejercicio.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
}
