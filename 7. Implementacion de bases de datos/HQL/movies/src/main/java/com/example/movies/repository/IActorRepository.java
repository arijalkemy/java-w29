package com.example.movies.repository;

import com.example.movies.dto.response.ActorDto;
import com.example.movies.dto.response.ActorFavoriteMovieDto;
import com.example.movies.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor, Integer> {
    // asi seria con partial entities
    @Query("SELECT new com.example.movies.dto.response.ActorFavoriteMovieDto(a.firstName, a.lastName, m.title) " +
            "FROM Actor a JOIN a.favoriteMovie m " +
            "WHERE a.favoriteMovie IS NOT NULL")
    List<ActorFavoriteMovieDto> findActorWhoHasFavoriteMovie();

    @Query("select a from Actor a where a.rating > :rating")
    List<Actor> findActorRatingGreaterThan(Double rating);

    @Query("select a from Actor a join a.movies m where m.title = :movie")
    List<Actor> findActorsByMovie(String movie);
}