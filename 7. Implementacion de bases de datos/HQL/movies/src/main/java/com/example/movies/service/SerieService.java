package com.example.movies.service;

import com.example.movies.dto.response.SerieDto;
import com.example.movies.repository.ISerieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService{
    @Autowired
    ISerieRepository iSerieRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<SerieDto> searchSerieByNumberOfSeasons(Integer num) {
        return iSerieRepository.findSerieByNumberOfSeasons(num)
                .stream()
                .map(s -> modelMapper.map(s, SerieDto.class))
                .toList();
    }
}
