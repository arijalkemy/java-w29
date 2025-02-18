package ejerciciopractico4.movies.ejercicio_practico_4.movies.repository;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IEpisodesReporsitory extends JpaRepository<Episodes, Long> {
    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @Query("SELECT e FROM Episodes e JOIN e.actors a WHERE a.id=:idactor")
    List<Episodes> findByActor(Long idactor);
}
