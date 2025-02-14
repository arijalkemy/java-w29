package com.example.students.repository;

import com.example.students.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query("SELECT m FROM Movie m JOIN m.genre g WHERE g.id = :genreId")
    List<Movie> findAllByGenreId(Integer genreId);

    // Con que al menos un actor tenga más de ese rating, ya se incluye la película
    @Query("SELECT m FROM Movie m JOIN m.actors a WHERE a.rating >= :minRating")
    List<Movie> findAllByMinActorsRating(Double minRating);

    @Query("SELECT DISTINCT m FROM Movie m JOIN m.actors a WHERE a.id = :actorId")
    List<Movie> findAllByActorId(Integer actorId);

    @Query("SELECT m.genre.name, m.title FROM Movie m ORDER BY m.genre.name")
    List<String[]> findMoviesGroupedByGenre();
}
