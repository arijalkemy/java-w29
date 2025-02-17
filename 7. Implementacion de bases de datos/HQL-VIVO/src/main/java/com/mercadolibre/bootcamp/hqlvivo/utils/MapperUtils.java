package com.mercadolibre.bootcamp.hqlvivo.utils;

import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPatenteDto;
import com.mercadolibre.bootcamp.hqlvivo.dto.VehiculoPatenteModeloMarcaDto;
import com.mercadolibre.bootcamp.hqlvivo.model.Vehiculo;

public class MapperUtils {

    public static VehiculoPatenteDto vehiculoToVehiculoPatenteDto(Vehiculo vehiculo) {
        return new VehiculoPatenteDto(
          vehiculo.getPatente()
        );
    }

    public static VehiculoPatenteModeloMarcaDto vehiculoToVehiculoPatenteModeloMarcaDto(Vehiculo vehiculo) {
        return new VehiculoPatenteModeloMarcaDto(
                vehiculo.getPatente(),
                vehiculo.getMarca(),
                vehiculo.getModelo()
        );
    }

}
