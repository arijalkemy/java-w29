package com.example.moviesHQL.utils;

import com.example.moviesHQL.dto.response.ActorDTO;
import com.example.moviesHQL.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorMapper INSTANCE = Mappers.getMapper(ActorMapper.class);

    ActorDTO actorToActorDTO(Actor actor);
}
