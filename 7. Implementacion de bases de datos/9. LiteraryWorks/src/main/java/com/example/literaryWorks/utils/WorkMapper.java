package com.example.literaryWorks.utils;

import com.example.literaryWorks.dto.WorkDTO;
import com.example.literaryWorks.model.Work;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WorkMapper {
    WorkMapper INSTANCE = Mappers.getMapper(WorkMapper.class);

    WorkDTO toDTO(Work work);
    Work toEntity(WorkDTO workDTO);
}
