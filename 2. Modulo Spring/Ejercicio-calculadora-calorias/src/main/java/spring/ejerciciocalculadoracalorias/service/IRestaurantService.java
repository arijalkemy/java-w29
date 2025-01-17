package spring.ejerciciocalculadoracalorias.service;

import spring.ejerciciocalculadoracalorias.dto.request.PlatoDTO;
import spring.ejerciciocalculadoracalorias.dto.response.InfoPlatoDTO;

public interface IRestaurantService {
    InfoPlatoDTO getInfoPlato(PlatoDTO platoInfoRequest);
}
