package org.example.ej_movies.repository;

import org.example.ej_movies.model.Episode;
import org.example.ej_movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Integer> {

    //    Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("SELECT s FROM Serie s WHERE size(s.seasons) > :seasons")
    List<Serie> getAllSeriesBySeasons(int season);

    //    Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE a.firstName LIKE :actor")
    List<Episode> getAllEpisodesByActor(String actor);
}
