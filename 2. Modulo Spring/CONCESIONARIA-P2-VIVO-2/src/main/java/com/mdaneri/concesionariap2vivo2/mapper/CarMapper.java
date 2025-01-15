package com.mdaneri.concesionariap2vivo2.mapper;

import com.mdaneri.concesionariap2vivo2.dto.request.RequestCarDTO;
import com.mdaneri.concesionariap2vivo2.dto.response.ResponseCarDTO;
import com.mdaneri.concesionariap2vivo2.entity.Car;
import com.mdaneri.concesionariap2vivo2.util.DateUtils;

import java.time.LocalDate;
import java.util.Arrays;

public class CarMapper {

    public static ResponseCarDTO toDTO(Car car) {
        return new ResponseCarDTO(
                car.getBrand(),
                car.getModel(),
                car.getManufacturingDate().toString(),
                car.getNumberOfKilometers(),
                car.getDoors(),
                car.getPrice().toString(),
                car.getCurrency(),
                car.getCountOfOwners()
        );
    }

    public static Car fromDTO(RequestCarDTO carDTO) {
        return new Car(
                carDTO.getBrand(),
                carDTO.getModel(),
                DateUtils.convert(carDTO.getManufacturingDate()),
                carDTO.getNumberOfKilometers(),
                carDTO.getDoors(),
                Integer.parseInt(carDTO.getPrice()),
                carDTO.getCurrency(),
                carDTO.getServices(),
                carDTO.getCountOfOwners()
        );
    }
}