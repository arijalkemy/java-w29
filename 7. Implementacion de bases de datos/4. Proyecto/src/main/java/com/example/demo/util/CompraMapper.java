package com.example.demo.util;

import com.example.demo.dto.CompraDTO;
import com.example.demo.entities.Compra;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompraMapper {
    CompraMapper INSTANCE = Mappers.getMapper(CompraMapper.class);

    Compra compraDTOToCompra(CompraDTO compraDTO);

    CompraDTO compraToCompraDTO(Compra tester);
}
