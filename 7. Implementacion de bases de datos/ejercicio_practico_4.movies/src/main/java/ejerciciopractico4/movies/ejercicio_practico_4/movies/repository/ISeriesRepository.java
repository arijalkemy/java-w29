package ejerciciopractico4.movies.ejercicio_practico_4.movies.repository;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ISeriesRepository extends JpaRepository<Serie, Long> {
    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("SELECT s FROM Serie s WHERE size(s.seasons)>:cantseason")
    List<Serie> findBySeasons(Integer cantseason);
}
