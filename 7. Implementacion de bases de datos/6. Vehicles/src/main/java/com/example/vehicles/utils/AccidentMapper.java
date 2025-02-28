package com.example.vehicles.utils;

import com.example.vehicles.dto.AccidentDTO;
import com.example.vehicles.model.Accident;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccidentMapper {

    AccidentMapper INSTANCE = Mappers.getMapper(AccidentMapper.class);

    AccidentDTO accidentToAccidentDTO(Accident accident);
}
