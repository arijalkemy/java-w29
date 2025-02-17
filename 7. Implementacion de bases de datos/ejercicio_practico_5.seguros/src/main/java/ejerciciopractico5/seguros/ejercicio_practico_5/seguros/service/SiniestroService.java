package ejerciciopractico5.seguros.ejercicio_practico_5.seguros.service;

import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.MessageDto;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.dto.SiniestroDto;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.model.Sinietro;
import ejerciciopractico5.seguros.ejercicio_practico_5.seguros.repository.ISiniestroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroService implements ISiniestroService {

    private final ISiniestroRepository repository;

    public SiniestroService(ISiniestroRepository repository) {
        this.repository = repository;
    }

    @Override
    public MessageDto saveSiniestro(SiniestroDto siniestroDto) {
        ModelMapper modelMapper = new ModelMapper();
        Sinietro s = modelMapper.map(siniestroDto, Sinietro.class);
        s.setId(null);
        repository.save(s);
        return new MessageDto("Siniestro registrado correctamente");
    }

    @Override
    public List<SiniestroDto> getSiniestros() {
        ModelMapper modelMapper = new ModelMapper();
        List<Sinietro> siniestros = repository.findAll();
        return siniestros.stream().map(s -> modelMapper.map(s, SiniestroDto.class)).collect(Collectors.toList());
    }
}
