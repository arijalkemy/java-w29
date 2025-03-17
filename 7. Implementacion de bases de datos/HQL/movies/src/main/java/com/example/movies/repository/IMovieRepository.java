package com.example.movies.repository;

import com.example.movies.dto.response.ActorFavoriteMovieDto;
import com.example.movies.dto.response.MovieDto;
import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends CrudRepository<Movie, Integer> {

    @Query("select m from Movie m join m.actors a where a.rating > :rating")
    List<Movie> findMoviesByActorRating(Double rating);

    @Query("select m from Movie m join m.genre g where g.name = :genre")
    List<Movie> findMoviesByGenre(String genre);
}
