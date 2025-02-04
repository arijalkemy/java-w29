package com.mercadolibre.calculadorametroscuadrados.util;

import com.mercadolibre.calculadorametroscuadrados.dto.HouseDTO;
import com.mercadolibre.calculadorametroscuadrados.dto.RoomDTO;

import java.util.ArrayList;
import java.util.List;

public class HouseFactory {
    public static HouseDTO buildHouse() {
        List<RoomDTO> rooms = List.of(
                buildSmallRoom(),
                buildBigRoom()
        );
        return new HouseDTO("Casa1", "Street1", rooms);
    }

    public static HouseDTO buildHouseWithNoRooms() {
        List<RoomDTO> noRooms = new ArrayList<>();
        return new HouseDTO("Casa2", "Street2", noRooms);
    }

    public static RoomDTO buildBigRoom() {
        return new RoomDTO("Room2", 40, 60);
    }

    public static RoomDTO buildSmallRoom() {
        return new RoomDTO("Room1", 10, 20);
    }
}
