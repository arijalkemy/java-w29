package com.example.moviesHQL.utils;

import com.example.moviesHQL.dto.response.MovieDTO;
import com.example.moviesHQL.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MovieMapper {
    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieDTO movieToMovieDTO(Movie movie);
}
