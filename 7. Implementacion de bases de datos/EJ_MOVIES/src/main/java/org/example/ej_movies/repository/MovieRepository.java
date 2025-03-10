package org.example.ej_movies.repository;

import org.example.ej_movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    //    Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT m FROM  Movie  m JOIN  m.actors a WHERE  a.rating > :rating")
    List<Movie> finDMovieByRatingActor(Double rating);

//    Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @Query("SELECT m FROM Movie m JOIN m.genre g WHERE  g.name = :genre" )
    List<Movie> finMovieByGenre(String genre);


}
