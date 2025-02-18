package ejerciciopractico4.movies.ejercicio_practico_4.movies.service;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.ActorsDto;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Actors;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.repository.IActorsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorsService implements IActorsService {

    private final IActorsRepository repository;
    private ModelMapper modelMapper;

    public ActorsService(IActorsRepository repository) {
        this.repository = repository;
        this.modelMapper = new ModelMapper();
    }


    @Override
    public List<ActorsDto> searchByFavoriteMovie() {
        List<Actors> actors = repository.findActorsByFavoriteMovies();
        return actors.stream().map(actor -> modelMapper.map(actor, ActorsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorsDto> searchByRating(Double rating) {
        List<Actors> actors = repository.findActorsByRating(rating);
        return actors.stream().map(actor -> modelMapper.map(actor, ActorsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ActorsDto> searchByMovies(String title) {
        List<Actors> actors = repository.findActorsByTitleMovie(title);
        return actors.stream().map(actor -> modelMapper.map(actor, ActorsDto.class)).collect(Collectors.toList());
    }
}
