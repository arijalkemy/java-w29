package com.mercadolibre.javawave29.concesionaria_de_autos.dto;

import com.mercadolibre.javawave29.concesionaria_de_autos.model.VehicleService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceVehicleDTO extends VehicleDTO{
    private List<VehicleService> services;
}
