package ejerciciopractico4.movies.ejercicio_practico_4.movies.service;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.MoviesDto;
import java.util.List;

public interface IMoviesService {
    List<MoviesDto> searchByRankingActors(Double ranking);
    List<MoviesDto> searchByGenres(String genreName);

}
