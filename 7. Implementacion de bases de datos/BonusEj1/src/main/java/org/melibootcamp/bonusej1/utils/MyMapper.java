package org.melibootcamp.bonusej1.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.melibootcamp.bonusej1.dto.GarmentDto;
import org.melibootcamp.bonusej1.dto.SalesDto;
import org.melibootcamp.bonusej1.entity.Garment;
import org.melibootcamp.bonusej1.entity.Sale;
import org.modelmapper.ModelMapper;

public class MyMapper {
   private static final ModelMapper modelMapper=new ModelMapper();
    public static GarmentDto garmenToGarmentDto(Garment garment) {
        return modelMapper.map(garment, GarmentDto.class);
    }
    public static Garment garmenDtoToGarment(GarmentDto garmentDto) {
        return modelMapper.map(garmentDto, Garment.class);
    }
    public static Sale saleDtoTosale(SalesDto salesDto) {
        return modelMapper.map(salesDto, Sale.class);
    }
    public static SalesDto salesToSaleDto(Sale sale) {
        return modelMapper.map(sale, SalesDto.class);
    }
}
