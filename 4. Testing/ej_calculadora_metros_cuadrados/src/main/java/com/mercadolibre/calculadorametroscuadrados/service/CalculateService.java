package com.mercadolibre.calculadorametroscuadrados.service;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.HouseResponseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;
import org.springframework.stereotype.Service;

@Service
public class CalculateService {
    public HouseResponseDTO calculate(HouseDTO house) {
        HouseResponseDTO response = new HouseResponseDTO(house);
        calculateRoomSquareFeet(house, response);
        response.setPrice(calculatePrice(response.getSquareFeet()));
        return response;
    }

    private void calculateRoomSquareFeet(HouseDTO house, HouseResponseDTO response) {
        Integer totalSquareFeet = 0;
        RoomDTO biggest = null;
        Integer maxRoom = 0;

        if (house.getRooms() == null || house.getRooms().isEmpty()) {
            throw new IllegalArgumentException("La casa debe tener al menos una habitación");
        }

        for (RoomDTO room : house.getRooms()) {

            if (room.getWidth() <= 0 || room.getLength() <= 0) {
                throw new IllegalArgumentException("Las dimensiones de la habitación deben ser mayores que cero");
            }

            Integer squareFeet = room.getSquareFeet();

            totalSquareFeet += Integer.valueOf(squareFeet);

            if (biggest == null || squareFeet > maxRoom){
                biggest = room;
                maxRoom = squareFeet;
            }
        }
        response.setSquareFeet(totalSquareFeet);
        response.setBiggest(biggest);
    }

    private Integer calculatePrice(Integer result) {
        return result * 800;
    }
}
