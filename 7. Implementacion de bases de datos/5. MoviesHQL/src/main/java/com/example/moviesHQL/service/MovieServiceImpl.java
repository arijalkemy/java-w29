package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.response.MovieDTO;
import com.example.moviesHQL.model.Movie;
import com.example.moviesHQL.repository.IMovieRepository;
import com.example.moviesHQL.utils.MovieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements IMovieService {

    private final IMovieRepository movieRepository;

    @Override
    public List<MovieDTO> getMoviesByActorsRating(Double rating) {
        return parseList(movieRepository.getMoviesByActorsRating(rating));
    }

    @Override
    public List<MovieDTO> getMoviesByGenre(String genre) {
        return parseList(movieRepository.getMoviesByGenre(genre));
    }

    @Override
    public List<MovieDTO> getMoviesByLength(Integer length) {
        return parseList(movieRepository.getMoviesByLength(length));
    }

    private List<MovieDTO> parseList(List<Movie> movies) {
        return movies.stream()
                .map(MovieMapper.INSTANCE::movieToMovieDTO)
                .toList();
    }
}
