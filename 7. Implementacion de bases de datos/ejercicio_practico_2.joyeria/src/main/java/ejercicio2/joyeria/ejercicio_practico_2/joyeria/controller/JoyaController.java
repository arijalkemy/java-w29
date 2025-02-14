package ejercicio2.joyeria.ejercicio_practico_2.joyeria.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.CreateJoyaRequestDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.CreateJoyaResponseDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.ReadJoyasResponseDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.dto.UpdateJoyaRequestDto;
import ejercicio2.joyeria.ejercicio_practico_2.joyeria.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    private IJoyaService service;

    //Crear una joya URI: /jewerly/new
    @PostMapping("/jewerly/new")
    public ResponseEntity<CreateJoyaResponseDto> createJoya(@RequestBody CreateJoyaRequestDto createJoyaRequestDto){
        return ResponseEntity.ok(service.createJoya(createJoyaRequestDto));
    }

    //Mostrar toddas las joyas (URI: /jewerly)
    @GetMapping("/jewerly")
    public ResponseEntity<List<ReadJoyasResponseDto>> readJoyas(){
        return ResponseEntity.ok(service.readJoyas());
    }

    //actualizar joyas URI: /jewerly/update/{id}
    @PostMapping("/jewerly/update/{id}")
    public ResponseEntity<ReadJoyasResponseDto> updateJoyas(@PathVariable Long id, @RequestBody UpdateJoyaRequestDto joya) throws JsonMappingException {
        return ResponseEntity.ok(service.updateJoya(id,joya));
    }

    //eliminar una joya URI: /jewerly/delete/{id}
    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<List<ReadJoyasResponseDto>> deleteJoyas(@PathVariable Long id){
        return ResponseEntity.ok(service.deleteJoyas(id));
    }
}
