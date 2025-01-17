package org.example.ej_concesionaria_autos.Services;

import org.example.ej_concesionaria_autos.Dtos.VehiculoDTO;
import org.example.ej_concesionaria_autos.Entities.Vehiculo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IVehiculoService {

    Vehiculo add(VehiculoDTO vehiculo);

    List<VehiculoDTO> getAll();

    Optional<VehiculoDTO> getVehiculoById(Integer id);

    List<VehiculoDTO> getVehiculoByPrice(Integer priceSince, Integer princeTo);

    List<VehiculoDTO> getVehiculoByDate(Date dateSince, Date dateTo);


}
