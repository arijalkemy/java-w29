package ejerciciopractico4.movies.ejercicio_practico_4.movies.service;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.ActorsDto;

import java.util.List;

public interface IActorsService {
    public List<ActorsDto> searchByFavoriteMovie();
    public List<ActorsDto> searchByRating(Double rating);
    public List<ActorsDto> searchByMovies(String title);
}
