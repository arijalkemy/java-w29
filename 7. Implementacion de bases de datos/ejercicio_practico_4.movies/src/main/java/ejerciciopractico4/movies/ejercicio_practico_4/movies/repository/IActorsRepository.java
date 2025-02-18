package ejerciciopractico4.movies.ejercicio_practico_4.movies.repository;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IActorsRepository extends JpaRepository<Actors,Long> {
    //Listar todos los actores que tengan declarada una película favorita.
    @Query("SELECT a FROM Actors a WHERE a.favoriteMovie IS NOT NULL")
    List<Actors> findActorsByFavoriteMovies();
    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT a FROM Actors a WHERE a.rating >:ratingparam")
    List<Actors> findActorsByRating(Double ratingparam);
    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("SELECT a FROM Actors a JOIN a.movies m WHERE m.title = :title")
    List<Actors> findActorsByTitleMovie(String title);
}
