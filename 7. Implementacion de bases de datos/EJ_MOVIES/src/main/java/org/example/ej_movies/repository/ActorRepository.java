package org.example.ej_movies.repository;

import org.example.ej_movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    // Listar todos los actores que tengan declarada una película favorita.
    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findAllWithFavoriteMovie();

    //    Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findAllByRating(Double rating);

    //    Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("SELECT a FROM  Actor a  JOIN  a.movies m WHERE  m.title = :movie")
    List<Actor> findAllByMovie(String movie);
}
