package spring.ejerciciocalculadoracalorias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.ejerciciocalculadoracalorias.dto.request.PlatoDTO;
import spring.ejerciciocalculadoracalorias.dto.response.InfoPlatoDTO;
import spring.ejerciciocalculadoracalorias.service.IRestaurantService;

@RestController
public class FoodController {
    IRestaurantService service;

    @Autowired
    public FoodController(IRestaurantService service) {
        this.service = service;
    }

    @PostMapping("/calculadora")
    public ResponseEntity<InfoPlatoDTO> getDishesInfo(@RequestBody PlatoDTO platoInfoRequest) {
        return ResponseEntity.ok(service.getInfoPlato(platoInfoRequest));
    }
}
