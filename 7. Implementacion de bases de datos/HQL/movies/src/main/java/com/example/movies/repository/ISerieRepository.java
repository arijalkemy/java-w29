package com.example.movies.repository;

import com.example.movies.dto.response.SerieDto;
import com.example.movies.model.Movie;
import com.example.movies.model.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISerieRepository extends CrudRepository<Serie, Integer> {
    @Query("select s from Serie s where SIZE(s.seasons) > :num")
    List<Serie> findSerieByNumberOfSeasons(Integer num);
}
