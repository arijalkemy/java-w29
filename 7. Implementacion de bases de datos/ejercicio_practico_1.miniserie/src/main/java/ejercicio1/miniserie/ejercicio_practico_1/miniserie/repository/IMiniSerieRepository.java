package ejercicio1.miniserie.ejercicio_practico_1.miniserie.repository;

import ejercicio1.miniserie.ejercicio_practico_1.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
