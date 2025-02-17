package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.service;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.*;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.model.Vehiculo;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.repository.IVehiculoRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{
    private final IVehiculoRepository repository;

    public VehiculoService(IVehiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public MessageDto saveVehiculo(VehiculoDto vehiculoDto) {
        ModelMapper modelMapper = new ModelMapper();
        Vehiculo vehiculo = modelMapper.map(vehiculoDto, Vehiculo.class);
        vehiculo.setId(null);
        repository.save(vehiculo);
        return new MessageDto("Vehiculo guardado con exito");
    }

    @Override
    public List<VehiculoDto> serchVehiculos() {
        List<Vehiculo> vehiculos = repository.findAll();
        ModelMapper modelMapper = new ModelMapper();
        return vehiculos.stream().map(vehiculo -> modelMapper.map(vehiculo, VehiculoDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<PatenteDto> serchPatentes() {
        List<String> patentes = repository.findAllPatente();
        return patentes.stream().map(PatenteDto::new).collect(Collectors.toList());
    }

    @Override
    public List<PantenteAndMarcDto> serchPantenteAndMarcByAno() {
        List<String []> patentesAndMarcas = repository.findAllPatenteMarca();
        return patentesAndMarcas.stream().map(strings -> new PantenteAndMarcDto(strings[0], strings[1])).collect(Collectors.toList());
    }

    @Override
    public List<PatenteDto> serchPatentesByAnoAndRuedas() {
        List<String> patentes = repository.findAllByRuedasAndYear(4, 2025);
        return patentes.stream().map(PatenteDto::new).collect(Collectors.toList());
    }

    @Override
    public List<PatenteMarcaModeloDto> serchPatenteMarcaModeloBySiniestroMonto() {
        List<String[]> patentesAndMarcasAndModelos = repository.findAllByPerdidaEconomica(10000);
        return patentesAndMarcasAndModelos.stream().map(x -> new PatenteMarcaModeloDto(x[0],x[1],x[2])).collect(Collectors.toList());
    }

    @Override
    public List<PatenteModeloMarcaDifDto> serchPatenteMarcaModeloMarcaDifBySiniestroMonto() {
        List<String[]> siniestros = repository.findAllByPerdidaEconomicaConDif(10000);
        return siniestros.stream().map(x -> new PatenteModeloMarcaDifDto(x[0],x[1],x[2],x[3])).collect(Collectors.toList());
    }
}
