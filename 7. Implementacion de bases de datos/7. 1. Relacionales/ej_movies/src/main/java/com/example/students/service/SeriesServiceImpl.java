package com.example.students.service;

import com.example.students.dto.SerieDto;
import com.example.students.dto.SeriesByGenreDto;
import com.example.students.repository.SerieRepository;
import com.example.students.util.Mapper;
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
                        result -> result[0], // El primer valor es el género
                        Collectors.mapping(result -> result[1], Collectors.toList()) // El segundo valor es el título de la serie
                ));

        return groupedByGenre.entrySet().stream()
                .map(entry -> new SeriesByGenreDto(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
