package meli.miniserie.repository;

import meli.miniserie.model.MiniSerie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iMiniSerieRepository extends JpaRepository<MiniSerie, Long> {
}
