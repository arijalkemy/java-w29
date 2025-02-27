package com.example.moviesHQL.utils;

import com.example.moviesHQL.dto.response.SerieDTO;
import com.example.moviesHQL.model.Serie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SerieMapper {
    SerieMapper INSTANCE = Mappers.getMapper(SerieMapper.class);

    SerieDTO serieToSerieDTO(Serie serie);
}
