package exercise.es_obras_literarias.service;

import exercise.es_obras_literarias.domain.Obra;
import exercise.es_obras_literarias.dto.request.ObraRequestDto;
import exercise.es_obras_literarias.dto.response.ObraResponseDto;
import exercise.es_obras_literarias.repository.ObraRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObraService implements IObraService{

    private final ObraRepository obraRepository;

    public ObraService(ObraRepository obraRepository){
        this.obraRepository = obraRepository;
    }

    @Override
    public ObraResponseDto save(ObraRequestDto obraRequestDto) {
        ModelMapper mapper = new ModelMapper();

        Obra savedObra = this.obraRepository.save(mapper.map(obraRequestDto, Obra.class));

        return mapper.map(savedObra, ObraResponseDto.class);
    }

    @Override
    public List<ObraResponseDto> findByAuthor(String author) {
        ModelMapper mapper = new ModelMapper();
        List<Obra> obras = this.obraRepository.findByAutor(author);

        return obras.stream()
                .map(obra -> mapper.map(obra, ObraResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraResponseDto> findTop5CantidadPaginas() {
        ModelMapper mapper = new ModelMapper();
        List<Obra> obras = this.obraRepository.findTop5ByOrderByCantidadPaginasDesc()
                ;

        return obras.stream()
                .map(obra -> mapper.map(obra, ObraResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraResponseDto> findByAnioPublicacionBefore(Integer year) {
        ModelMapper mapper = new ModelMapper();

        List<Obra> obras = this.obraRepository.findByAnioPublicacionBefore(year);

        return obras.stream()
                .map(obra -> mapper.map(obra, ObraResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraResponseDto> findByEditorial(String editorial) {
        ModelMapper mapper = new ModelMapper();

        List<Obra> obras = this.obraRepository.findByEditorial(editorial);

        return obras.stream()
                .map(obra -> mapper.map(obra, ObraResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ObraResponseDto> findByName(String name) {
        ModelMapper mapper = new ModelMapper();

        List<Obra> obras = this.obraRepository.findByNombreContaining(name);

        return obras.stream()
                .map(obra -> mapper.map(obra, ObraResponseDto.class))
                .collect(Collectors.toList());
    }
}
