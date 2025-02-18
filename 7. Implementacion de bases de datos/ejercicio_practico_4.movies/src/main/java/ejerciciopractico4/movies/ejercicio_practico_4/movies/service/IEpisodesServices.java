package ejerciciopractico4.movies.ejercicio_practico_4.movies.service;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.EpisodesDto;

import java.util.List;

public interface IEpisodesServices {
    List<EpisodesDto> searchEpisodesByActor(Long actorId);
}
