package com.example.moviesHQL.service;

import com.example.moviesHQL.dto.response.EpisodeDTO;
import com.example.moviesHQL.model.Episode;
import com.example.moviesHQL.repository.IEpisodeRepository;
import com.example.moviesHQL.utils.EpisodeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EpisodeServiceImpl implements IEpisodeService {

    private final IEpisodeRepository episodeRepository;

    @Override
    public List<EpisodeDTO> getEpisodesByActor(String name) {
        List<Episode> episodes = episodeRepository.getEpisodesByActor(name);
        return episodes
                .stream()
                .map(EpisodeMapper.INSTANCE::episodeToEpisodeDTO)
                .toList();
    }
}
