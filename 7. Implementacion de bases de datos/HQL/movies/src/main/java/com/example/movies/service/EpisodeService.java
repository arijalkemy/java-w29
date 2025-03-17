package com.example.movies.service;

import com.example.movies.dto.response.EpisodeDto;
import com.example.movies.model.Episode;
import com.example.movies.repository.IEpisodeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService implements IEpisodeService{
    @Autowired
    IEpisodeRepository iEpisodeRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<EpisodeDto> searchEpisodesByActorName(String name, String lastname) {
        return iEpisodeRepository.findEpisodesByActorName(name, lastname)
                .stream()
                .map(e -> modelMapper.map(e, EpisodeDto.class))
                .toList();
    }

}
