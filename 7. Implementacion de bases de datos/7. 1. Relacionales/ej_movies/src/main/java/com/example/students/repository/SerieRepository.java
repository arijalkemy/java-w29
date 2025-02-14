package com.example.students.repository;

import com.example.students.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {
    @Query("SELECT s FROM Serie s WHERE size(s.seasons) >= :minSeasons")
    List<Serie> findAllByMinSeasonsSize(Integer minSeasons);

    @Query("SELECT s FROM Serie s " +
            "JOIN s.seasons se " +
            "JOIN se.episodes e " +
            "JOIN e.actors a " +
            "WHERE a.id = :actorId")
    List<Serie> findAllByActorId(Integer actorId);

    @Query("SELECT s.genre.name, s.title FROM Serie s ORDER BY s.genre.name")
    List<String[]> findSeriesGroupedByGenre();
}
