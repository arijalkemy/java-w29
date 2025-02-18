package ejerciciopractico4.movies.ejercicio_practico_4.movies.service;

import ejerciciopractico4.movies.ejercicio_practico_4.movies.dto.SerieDto;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Seasons;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.model.Serie;
import ejerciciopractico4.movies.ejercicio_practico_4.movies.repository.ISeriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeriesService implements ISeriesService {
    private final ISeriesRepository repo;
    private ModelMapper mapper;

    public SeriesService(ISeriesRepository repo) {
        this.repo = repo;
        this.mapper = new ModelMapper();
    }


    @Override
    public List<SerieDto> searchSeriesBySeason(Integer season) {
        List<Serie> series = repo.findBySeasons(season);
        return series.stream().map(serie -> mapper.map(serie, SerieDto.class)).collect(Collectors.toList());
    }
}
