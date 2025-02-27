package com.example.moviesHQL.repository;

import com.example.moviesHQL.model.Episode;
import com.example.moviesHQL.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends JpaRepository<Serie, Integer> {

    // Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("SELECT s FROM Serie s WHERE size(s.seasons) >= :seasons")
    List<Serie> getSeriesBySeasons(@Param("seasons") Integer seasons);
}
