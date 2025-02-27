package com.example.moviesHQL.repository;

import com.example.moviesHQL.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends JpaRepository<Episode, Integer> {
    // Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE a.firstName = :name")
    List<Episode> getEpisodesByActor(@Param("name") String name);
}
