package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.response.SerieDTO;
import com.example.moviesHQL.repository.ISerieRepository;
import com.example.moviesHQL.utils.SerieMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SerieServiceImpl implements ISerieService{

    private final ISerieRepository serieRepository;

    @Override
    public List<SerieDTO> getSeriesBySeasons(Integer season) {
        return serieRepository.getSeriesBySeasons(season)
                .stream()
                .map(SerieMapper.INSTANCE::serieToSerieDTO)
                .toList();
    }
}
