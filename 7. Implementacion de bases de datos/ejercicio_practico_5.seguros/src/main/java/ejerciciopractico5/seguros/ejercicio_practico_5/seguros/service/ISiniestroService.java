package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.service;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.MessageDto;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.SiniestroDto;

import java.util.List;

public interface ISiniestroService {

    MessageDto saveSiniestro(SiniestroDto siniestroDto);
    List<SiniestroDto> getSiniestros();
}
