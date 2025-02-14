package com.example.students.repository;

import com.example.students.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query("SELECT a FROM Actor a JOIN a.movies m WHERE m.title = :title")
    List<Actor> findByMovieTitle(String title);

    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findAllWithFavMovie();

    @Query("SELECT a FROM Actor a WHERE a.rating >= :minRating")
    List<Actor> findAllByRatingGreaterThanEqual(Double minRating);
}
