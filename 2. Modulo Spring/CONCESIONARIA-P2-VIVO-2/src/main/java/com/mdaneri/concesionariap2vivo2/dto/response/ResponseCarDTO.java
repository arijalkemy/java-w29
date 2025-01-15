package com.mdaneri.concesionariap2vivo2.dto.response;

import com.mdaneri.concesionariap2vivo2.dto.CarDTO;
import com.mdaneri.concesionariap2vivo2.entity.Service;

import java.util.List;

public class ResponseCarDTO extends CarDTO {

    public ResponseCarDTO(String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, String countOfOwners) {
        super(brand, model, manufacturingDate, numberOfKilometers, doors, price, currency, countOfOwners);
    }

}
