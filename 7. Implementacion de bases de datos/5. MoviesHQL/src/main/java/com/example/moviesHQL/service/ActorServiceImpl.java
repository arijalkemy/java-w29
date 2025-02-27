package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.response.ActorDTO;
import com.example.moviesHQL.model.Actor;
import com.example.moviesHQL.repository.IActorRepository;
import com.example.moviesHQL.utils.ActorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements IActorService {
    private final IActorRepository actorRepository;


    @Override
    public List<ActorDTO> getActorsHasOneFavoriteMovie() {
        return paserList(actorRepository.getActorsHasOneFavoriteMovie());
    }

    @Override
    public List<ActorDTO> getActorsByRating(Double rating) {
        return paserList(actorRepository.getActorsByRating(rating));
    }

    @Override
    public List<ActorDTO> getActorsByMovieTitle(String title) {
        return paserList(actorRepository.getActorsByMovieTitle(title));
    }

    @Override
    public List<ActorDTO> getActorsByAwardsMovies() {
        return paserList(actorRepository.getActorsByAwardsMovies());
    }

    private List<ActorDTO> paserList(List<Actor> actors) {
        return actors.stream()
                .map(ActorMapper.INSTANCE::actorToActorDTO)
                .toList();
    }
}
