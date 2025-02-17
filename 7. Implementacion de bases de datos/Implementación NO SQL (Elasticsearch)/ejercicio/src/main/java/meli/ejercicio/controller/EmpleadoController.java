package meli.ejercicio.controller;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.domain.Empleado;
import meli.ejercicio.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/empleados")
@RequiredArgsConstructor
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    @PostMapping
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado) {
        Empleado nuevoEmpleado = empleadoService.agregarEmpleado(empleado);
        return ResponseEntity.ok(nuevoEmpleado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> modificarEmpleado(@PathVariable String id, @RequestBody Empleado empleado) {
        Optional<Empleado> empleadoExistente = empleadoService.obtenerEmpleado(id);
        if (empleadoExistente.isPresent()) {
            empleado.setId(id);
            Empleado empleadoActualizado = empleadoService.modificarEmpleado(empleado);
            return ResponseEntity.ok(empleadoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Empleado>> obtenerEmpleados() {
        Iterable<Empleado> empleados = empleadoService.obtenerEmpleados();
        return ResponseEntity.ok(empleados);
    }
}
