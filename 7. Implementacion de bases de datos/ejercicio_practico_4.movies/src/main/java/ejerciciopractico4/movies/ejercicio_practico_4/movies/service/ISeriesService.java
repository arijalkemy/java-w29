package ejerciciopractico4.movies.ejercicio_practico_4.movies.service;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.SerieDto;

import java.util.List;

public interface ISeriesService {
    List<SerieDto> searchSeriesBySeason(Integer season);
}
