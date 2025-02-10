package com.example.empresa.util;

import com.example.empresa.dto.VehiculoDto;
import com.example.empresa.model.Vehiculo;

public class Mapper {
    public static VehiculoDto vehiculoDto(Vehiculo v) {
        return new VehiculoDto(v.getId(), v.getMarca(), v.getModelo(), v.getPatente(), v.getAnio(),
                v.getCantidadRuedas());
    }
}
