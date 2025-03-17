package com.example.movies.service;

import com.example.movies.dto.response.ActorFavoriteMovieDto;
import com.example.movies.dto.response.MovieDto;
import com.example.movies.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {
    @Autowired
    private IMovieRepository iMovieRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<MovieDto> searchMoviesByActorRating(Double rating) {
        return iMovieRepository.findMoviesByActorRating(rating)
                .stream()
                .map(m -> modelMapper.map(m, MovieDto.class))
                .toList();
    }

    @Override
    public List<MovieDto> searchMoviesByGenre(String genre) {
        return iMovieRepository.findMoviesByGenre(genre)
                .stream()
                .map(m -> modelMapper.map(m, MovieDto.class))
                .toList();
    }
}
