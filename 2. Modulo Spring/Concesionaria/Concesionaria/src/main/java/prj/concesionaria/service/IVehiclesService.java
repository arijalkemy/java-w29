package prj.concesionaria.service;

import org.springframework.stereotype.Service;
import prj.concesionaria.dto.ResponseDto;
import prj.concesionaria.dto.VehiclesDto;

import java.util.List;
@Service
public interface IVehiclesService {
    ResponseDto addVehicle(VehiclesDto vehicle);
    List<VehiclesDto> getVehicles();
    List<VehiclesDto>getByYears(Integer since,Integer to);
    List<VehiclesDto>getByPrices(Integer since,Integer to);
    VehiclesDto getById(Integer id);
}
