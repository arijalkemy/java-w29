package ejerciciopractico4.movies.ejercicio_practico_4.movies.service;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.EpisodesDto;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Episodes;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.repository.IEpisodesReporsitory;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodesService implements IEpisodesServices{
    private final IEpisodesReporsitory repo;
    private ModelMapper modelMapper;

    public EpisodesService(IEpisodesReporsitory repo) {
        this.repo = repo;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<EpisodesDto> searchEpisodesByActor(Long actorId) {
        List<Episodes> episodes =repo.findByActor(actorId);
        return episodes.stream().map(episode -> modelMapper.map(episode, EpisodesDto.class)).collect(Collectors.toList());
    }
}
