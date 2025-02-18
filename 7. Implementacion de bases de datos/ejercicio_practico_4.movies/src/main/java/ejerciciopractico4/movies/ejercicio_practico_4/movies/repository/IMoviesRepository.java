package ejerciciopractico4.movies.ejercicio_practico_4.movies.repository;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<Movies, Integer> {
    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT p FROM Movies p JOIN p.actors a WHERE a.rating >:ratingparam")
    List<Movies> findMoviesByRatingParam(Double ratingparam);
    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @Query("SELECT p FROM Movies p JOIN p.genre g WHERE g.name=:generoparam")
    List<Movies> findMoviesByGenre(String generoparam);
}
