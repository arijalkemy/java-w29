package com.org.meli.showroom.util;

import lombok.Getter;
import org.modelmapper.ModelMapper;

public class ModelMapperUtil {

    @Getter
    private static final ModelMapper modelMapper = new ModelMapper();

    private ModelMapperUtil() {}

    public static <D, T> D map(T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

}