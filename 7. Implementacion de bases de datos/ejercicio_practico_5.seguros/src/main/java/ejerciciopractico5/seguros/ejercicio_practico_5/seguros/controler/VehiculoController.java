package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.controler;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.*;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/vehiculos")
public class VehiculoController {
    @Autowired
    private final VehiculoService service;

    public VehiculoController(VehiculoService service) {
        this.service = service;
    }

    @PostMapping("/new")
    public ResponseEntity<MessageDto> postVehiculo(@RequestBody VehiculoDto dto) {
        return ResponseEntity.ok(service.saveVehiculo(dto));
    }

    @GetMapping("/")
    public ResponseEntity<List<VehiculoDto>> getAll() {
        return ResponseEntity.ok(service.serchVehiculos());
    }

    @GetMapping("/patentes")
    public ResponseEntity<List<PatenteDto>> getAllPatentes() {
        return ResponseEntity.ok(service.serchPatentes());
    }

    @GetMapping("/patentesMarcas")
    public ResponseEntity<List<PantenteAndMarcDto>> getAllPatentesMarcas() {
        return ResponseEntity.ok(service.serchPantenteAndMarcByAno());
    }

    @GetMapping("/patentesByRuedasAndYear")
    public ResponseEntity<List<PatenteDto>> getAllPatentesByRuedasAndYear() {
        return ResponseEntity.ok(service.serchPatentesByAnoAndRuedas());
    }

    @GetMapping("/sinietroByMonto")
    public ResponseEntity<List<PatenteMarcaModeloDto>> getSinietroByMonto() {
        return ResponseEntity.ok(service.serchPatenteMarcaModeloBySiniestroMonto());
    }

    @GetMapping("/sinietroByMontoConDif")
    public ResponseEntity<List<PatenteModeloMarcaDifDto>> getSinietroByMontoConDif() {
        return ResponseEntity.ok(service.serchPatenteMarcaModeloMarcaDifBySiniestroMonto());
    }
}
