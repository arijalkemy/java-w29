package com.example.movies.service;

import com.example.movies.dto.response.ActorDto;
import com.example.movies.dto.response.ActorFavoriteMovieDto;
import com.example.movies.repository.IActorRepository;
import com.example.movies.repository.IMovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService{
    @Autowired
    private IActorRepository iActorRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ActorFavoriteMovieDto> searchActorWhoHasFavoriteMovie() {
        return iActorRepository.findActorWhoHasFavoriteMovie();
    }

    @Override
    public List<ActorDto> searchActorActorRatingGreaterThan(Double rating) {
        return iActorRepository.findActorRatingGreaterThan(rating)
                .stream()
                .map(a -> modelMapper.map(a, ActorDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> searchActorsByMovie(String movie) {
        return iActorRepository.findActorsByMovie(movie)
                .stream()
                .map(a -> modelMapper.map(a, ActorDto.class))
                .toList();
    }


}
