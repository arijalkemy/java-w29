package com.mercadolibre.bootcamp.showroom.mappers;

import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.dto.GarmentDetailsDTO;
import com.mercadolibre.bootcamp.showroom.model.Garment;
import com.mercadolibre.bootcamp.showroom.model.GarmentDetails;

public class GarmentMapper {

    public static GarmentDTO toGarmentDTO(Garment garment) {
        if (garment == null) return null;
        return new GarmentDTO(
                garment.getName(),
                garment.getType(),
                garment.getBrand(),
                garment.getColor(),
                garment.getSize(),
                toGarmentDetailsDTO(garment.getGarmentDetails())
        );
    }

    public static Garment toGarmentEntity(GarmentDTO garmentDTO) {
        if (garmentDTO == null) return null;

        Garment garment = new Garment(
                null,
                garmentDTO.getName(),
                garmentDTO.getType(),
                garmentDTO.getBrand(),
                garmentDTO.getColor(),
                garmentDTO.getSize(),
                null
        );

        // Crear y establecer GarmentDetails
        GarmentDetails details = toGarmentDetailsEntity(garmentDTO.getDetailsDTO());
        if (details != null) {
            garment.setGarmentDetails(details);
            details.setGarment(garment); // Establecer la referencia bidireccional
        }

        return garment;
    }

    public static GarmentDetailsDTO toGarmentDetailsDTO(GarmentDetails garmentDetails) {
        if (garmentDetails == null) return null;
        return new GarmentDetailsDTO(
                garmentDetails.getAmount(),
                garmentDetails.getPrice()
        );
    }

    public static GarmentDetails toGarmentDetailsEntity(GarmentDetailsDTO garmentDetailsDTO) {
        if (garmentDetailsDTO == null) return null;
        return new GarmentDetails(
                null,
                garmentDetailsDTO.getAmount(),
                garmentDetailsDTO.getPrice(),
                null  // La referencia al Garment se establece en toGarmentEntity
        );
    }
}