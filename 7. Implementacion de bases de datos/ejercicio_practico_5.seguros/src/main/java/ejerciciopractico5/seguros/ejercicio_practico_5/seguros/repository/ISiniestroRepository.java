package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.repository;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.model.Sinietro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiniestroRepository extends JpaRepository<Sinietro,Long> {
}
