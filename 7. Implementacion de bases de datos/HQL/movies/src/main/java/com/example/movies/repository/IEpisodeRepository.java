package com.example.movies.repository;

import com.example.movies.dto.response.EpisodeDto;
import com.example.movies.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEpisodeRepository extends CrudRepository<Episode, Integer> {

    @Query("select e from Episode e join e.actors a where a.firstName = :name and a.lastName = :lastname")
    List<Episode> findEpisodesByActorName(String name, String lastname);
}
