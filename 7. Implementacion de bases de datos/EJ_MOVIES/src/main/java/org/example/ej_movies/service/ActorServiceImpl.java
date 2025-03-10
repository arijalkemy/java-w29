package org.example.ej_movies.service;

import lombok.RequiredArgsConstructor;
import org.example.ej_movies.dto.ActorDto;
import org.example.ej_movies.repository.ActorRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements IActorService {

    private final ActorRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    @Override
    public List<ActorDto> getAllActors() {

        return repository.findAll()
                .stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> getActorsByFavoriteMovie() {

        return repository.findAllWithFavoriteMovie()
                .stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> findAllByRating(Double rating) {

        return repository.findAllByRating(rating)
                .stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .toList();
    }

    @Override
    public List<ActorDto> findAllByMovie(String movie) {

        return repository.findAllByMovie(movie)
                .stream()
                .map(actor -> mapper.map(actor, ActorDto.class))
                .toList();
    }
}
