package com.example.moviesHQL.repository;

import com.example.moviesHQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {

    // Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.rating > :rating")
    List<Movie> getMoviesByActorsRating(@Param("rating") Double rating);

    // Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @Query("SELECT m FROM Movie m JOIN m.genre g WHERE g.name =:genre")
    List<Movie> getMoviesByGenre(@Param("genre") String genre);

    // Listar todas las peliculas que duren más de 180 min
    @Query("SELECT m FROM Movie m WHERE m.length > :length")
    List<Movie> getMoviesByLength(@Param("length") Integer length);
}
