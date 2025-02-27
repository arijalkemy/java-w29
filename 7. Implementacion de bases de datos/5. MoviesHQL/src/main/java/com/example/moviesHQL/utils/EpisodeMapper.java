package com.example.moviesHQL.utils;

import com.example.moviesHQL.dto.response.EpisodeDTO;
import com.example.moviesHQL.model.Episode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EpisodeMapper {

    EpisodeMapper INSTANCE = Mappers.getMapper(EpisodeMapper.class);

    EpisodeDTO episodeToEpisodeDTO(Episode episode);
}
