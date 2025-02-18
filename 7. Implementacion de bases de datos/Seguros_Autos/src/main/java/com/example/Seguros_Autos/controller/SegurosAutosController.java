package com.example.Seguros_Autos.controller;

import com.example.Seguros_Autos.DTO.PatenteMarcaDTO;
import com.example.Seguros_Autos.DTO.VehiculoSiniestroDTO;
import com.example.Seguros_Autos.DTO.VehiculoSiniestroTotalLossDTO;
import com.example.Seguros_Autos.service.IVehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SegurosAutosController {

    private final IVehiculoService vehiculoService;

    @Autowired
    public SegurosAutosController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    // Endpoint para listar todas las patentes
    @GetMapping("/vehiculos/patentes")
    public ResponseEntity<List<String>> getAllPatentes() {
        List<String> patentes = vehiculoService.findAllPatentes();
        return new ResponseEntity<>(patentes, HttpStatus.OK); //
    }

    // Endpoint para listar patente y marca ordenados por año de fabricación
    @GetMapping("/vehiculos/patentes-marcas")
    public ResponseEntity<List<PatenteMarcaDTO>> getPatenteAndMarcaOrderedByAnioFabricacion() {
        List<PatenteMarcaDTO> patentesMarcas = vehiculoService.getPatentesAndMarcasOrderedByAnioFabricacion();
        return new ResponseEntity<>(patentesMarcas, HttpStatus.OK);
    }

    // Endpoint para listar patentes de vehículos con más de 4 ruedas y fabricados en el año dado
    @GetMapping("/vehiculos/cuatro-ruedas-ano-actual")
    public List<String> getVehiculosCuatroRuedasAndCurrentYear() {
        return vehiculoService.getVehiculosCuatroRuedasAndCurrentYear();
    }

    // Endpoint para listar matrícula, marca y modelo de vehículos con siniestros con pérdida mayor a 10000 pesos
    @GetMapping("/vehiculos/siniestros/alta-perdida")
    public ResponseEntity<List<VehiculoSiniestroDTO>> getPatenteMarcaModeloBySiniestroWithLossGreaterThan10000() {
        List<VehiculoSiniestroDTO> siniestros = vehiculoService.findPatenteMarcaModeloBySiniestroWithLossGreaterThan10000();
        return ResponseEntity.ok(siniestros);
    }

    // Endpoint para listar matrícula, marca, modelo y la pérdida total de vehículos con siniestros con pérdida mayor a 10000 pesos
    @GetMapping("/vehiculos/siniestros/total-perdida")
    public ResponseEntity<List<VehiculoSiniestroTotalLossDTO>> getPatenteMarcaModeloAndTotalLossBySiniestroWithLossGreaterThan10000() {
        List<VehiculoSiniestroTotalLossDTO> siniestros = vehiculoService.findPatenteMarcaModeloAndTotalLossBySiniestroWithLossGreaterThan10000();
        return ResponseEntity.ok(siniestros);
    }
}
