package com.org.meli.movies_db.service;

import com.org.meli.movies_db.dto.SerieDto;
import com.org.meli.movies_db.dto.SeriesByGenreDto;
import com.org.meli.movies_db.repository.SerieRepository;
import com.org.meli.movies_db.util.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesService {

    private final SerieRepository serieRepository;

    @Override
    public List<SerieDto> getAll() {
        return serieRepository.findAll()
                .stream()
                .map(Mapper::toSerieDto)
                .toList();
    }

    @Override
    public List<SerieDto> getAllWithMinSeasons(Integer minSeasons) {
        return serieRepository.findAllByMinSeasonsSize(minSeasons)
                .stream()
                .map(Mapper::toSerieDto)
                .toList();
    }

    @Override
    public List<SeriesByGenreDto> getAllByGenre() {
        List<String[]> results = serieRepository.findSeriesGroupedByGenre();

        Map<String, List<String>> groupedByGenre = results.stream()
                .collect(Collectors.groupingBy(
                        result -> result[0],
                        Collectors.mapping(result -> result[1], Collectors.toList())
                ));

        return groupedByGenre.entrySet().stream()
                .map(entry -> new SeriesByGenreDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}