package com.example.ThePearls.utils;

import com.example.ThePearls.dto.request.JewelDtoRequest;
import com.example.ThePearls.dto.response.JewelDtoResponse;
import com.example.ThePearls.dto.response.NewJewelDto;
import com.example.ThePearls.entity.Jewel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JewelMapper {

    JewelMapper INSTANCE = Mappers.getMapper(JewelMapper.class);

    @Mappings({
            @Mapping(target = "id_number", ignore = true),
            @Mapping(source = "ownStone", target = "ownStone")
    })
    Jewel jewelDtoToJewel(JewelDtoRequest jewelDtoRequest);

    @Mappings({
            @Mapping(target = "id_number", source = "id_number"),
            @Mapping(target = "name", source = "name")
    })
    NewJewelDto jewelToJewelDto(Jewel jewel);

    JewelDtoResponse jewelToJewelDtoResponse(Jewel jewelDtoRequest);
}
