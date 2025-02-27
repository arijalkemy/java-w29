package com.example.moviesHQL.repository;

import com.example.moviesHQL.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Integer> {

    // Listar todos los actores que tengan declarada una película favorita.
    @Query("SELECT a FROM Actor a JOIN a.favoriteMovieId f WHERE f.title != ''")
    List<Actor> getActorsHasOneFavoriteMovie();

    // Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> getActorsByRating(@Param("rating") Double rating);

    // Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("SELECT a FROM Actor a JOIN a.movies as m WHERE m.title = :title")
    List<Actor> getActorsByMovieTitle(@Param("title") String title);

    // Listar todos los actores con peliculas con más de 5 premios
    @Query("SELECT a FROM Actor a JOIN a.movies m WHERE m.awards >= 6")
    List<Actor> getActorsByAwardsMovies();
}
