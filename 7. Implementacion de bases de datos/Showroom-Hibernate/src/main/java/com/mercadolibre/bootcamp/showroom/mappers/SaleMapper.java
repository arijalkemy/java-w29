package com.mercadolibre.bootcamp.showroom.mappers;


import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.dto.SaleDTO;
import com.mercadolibre.bootcamp.showroom.model.Garment;
import com.mercadolibre.bootcamp.showroom.model.Sale;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaleMapper {

    public static SaleDTO toSaleDTO(Sale sale) {
        if (sale == null) return null;

        return new SaleDTO(
                sale.getId(),
                sale.getSoldOn(),
                sale.getMeansOfpayment(),
                sale.getTotal(),
                mapGarmentListToDTO(sale.getGarmentList())
        );
    }

    public static Sale toSaleEntity(SaleDTO saleDTO) {
        if (saleDTO == null) return null;

        Sale sale = new Sale(
                saleDTO.getId(),
                saleDTO.getSoldOn(),
                saleDTO.getMeansOfpayment(),
                saleDTO.getTotal(),
                new ArrayList<>()
        );

        if (saleDTO.getGarmentList() != null) {
            List<Garment> garments = mapGarmentListToEntity(saleDTO.getGarmentList());

            for (Garment garment : garments) {
                garment.setSale(sale);
            }

            sale.setGarmentList(garments);
        }
        return sale;
    }

    private static List<GarmentDTO> mapGarmentListToDTO(List<Garment> garments) {
        if (garments == null) return null;
        return garments.stream()
                .map(GarmentMapper::toGarmentDTO)
                .collect(Collectors.toList());
    }

    private static List<Garment> mapGarmentListToEntity(List<GarmentDTO> garmentDTOs) {
        if (garmentDTOs == null) return null;
        return garmentDTOs.stream()
                .map(GarmentMapper::toGarmentEntity)
                .collect(Collectors.toList());
    }
}
