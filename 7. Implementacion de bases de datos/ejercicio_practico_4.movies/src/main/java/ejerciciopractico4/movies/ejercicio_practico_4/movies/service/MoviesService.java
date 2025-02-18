package ejerciciopractico4.movies.ejercicio_practico_4.movies.service;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.MoviesDto;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Movies;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.repository.IMoviesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MoviesService implements IMoviesService {
    private final IMoviesRepository repository;
    private ModelMapper modelMapper;

    public MoviesService(IMoviesRepository repository) {
        this.repository = repository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<MoviesDto> searchByRankingActors(Double ranking) {
        List<Movies> movies = repository.findMoviesByRatingParam(ranking);
        return movies.stream().map(movie -> modelMapper.map(movie, MoviesDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<MoviesDto> searchByGenres(String genreName) {
        List<Movies> movies = repository.findMoviesByGenre(genreName);
        return movies.stream().map(movie -> modelMapper.map(movie, MoviesDto.class)).collect(Collectors.toList());
    }
}
