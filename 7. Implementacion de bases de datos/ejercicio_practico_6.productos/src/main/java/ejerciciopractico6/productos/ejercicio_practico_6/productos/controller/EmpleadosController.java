package ejerciciopractico6.productos.ejercicio_practico_6.productos.controller;

import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.EmpleadosDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.dto.MessageDto;
import ejerciciopractico6.productos.ejercicio_practico_6.productos.service.IEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadosController {
    @Autowired
    private final IEmpleadosService service;

    public EmpleadosController(IEmpleadosService service) {
        this.service = service;
    }


    @GetMapping("/all")
    public ResponseEntity<List<EmpleadosDto>> getAll() {
        return ResponseEntity.ok(service.findAllEmpleados());
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> postEmplado(@RequestBody EmpleadosDto empleadosDto) {
        return ResponseEntity.ok(service.saveEmpleado(empleadosDto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageDto> putEmplado(@RequestBody EmpleadosDto empleadosDto , @PathVariable String id) {
        return ResponseEntity.ok(service.updateEmpleado(id, empleadosDto));
    }
}
