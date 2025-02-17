package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.service;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.*;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    public MessageDto saveVehiculo(VehiculoDto vehiculoDto);
    public List<VehiculoDto> serchVehiculos();

    //Listar las patentes de todos los vehículos registrados
    List<PatenteDto> serchPatentes();
    //Listar la patente y la marca de todos los vehículos ordenados por año de fabricación.
    List<PantenteAndMarcDto> serchPantenteAndMarcByAno();
    //Listar la patente de todos los vehículos que tengan más de cuatro ruedas y hayan sido fabricados
    // en el corriente año.
    List<PatenteDto> serchPatentesByAnoAndRuedas();
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida
    // mayor de 10000 pesos.
    List<PatenteMarcaModeloDto> serchPatenteMarcaModeloBySiniestroMonto();
    //Listar la matrícula, marca y modelo de todos los vehículos que hayan tenido un siniestro con pérdida mayor de
    // 10000 pesos y mostrar a cuánto ascendió la pérdida total de todos ellos.
    List<PatenteModeloMarcaDifDto> serchPatenteMarcaModeloMarcaDifBySiniestroMonto();

}
