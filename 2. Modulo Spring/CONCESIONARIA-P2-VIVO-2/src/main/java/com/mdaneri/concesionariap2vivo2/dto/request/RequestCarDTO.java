package com.mdaneri.concesionariap2vivo2.dto.request;

import com.mdaneri.concesionariap2vivo2.dto.CarDTO;
import com.mdaneri.concesionariap2vivo2.entity.Service;

import java.util.List;

public class RequestCarDTO extends CarDTO {

    private List<Service> services;

    public RequestCarDTO(String brand, String model, String manufacturingDate, String numberOfKilometers, String doors, String price, String currency, String countOfOwners, List<Service> services) {
        super(brand, model, manufacturingDate, numberOfKilometers, doors, price, currency, countOfOwners);
        this.services = services;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }
}
