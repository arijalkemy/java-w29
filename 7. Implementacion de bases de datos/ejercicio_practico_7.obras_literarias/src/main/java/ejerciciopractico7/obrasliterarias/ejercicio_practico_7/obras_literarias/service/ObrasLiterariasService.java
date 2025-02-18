package ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.service;

import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.dto.MessageDto;
import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.dto.ObrasLiterariasDto;
import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.model.ObrasLiterarias;
import ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.repository.IObrasLiteriariasRespository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObrasLiterariasService implements IObrasLiteriariasService{
    private final IObrasLiteriariasRespository repo;

    public ObrasLiterariasService(IObrasLiteriariasRespository repo) {
        this.repo = repo;
    }

    @Override
    public MessageDto saveObras(ObrasLiterariasDto obrasLiterariasDto) {
        ModelMapper modelMapper = new ModelMapper();
        ObrasLiterarias obra = modelMapper.map(obrasLiterariasDto, ObrasLiterarias.class);
        System.out.println(obra.getId() + obra.getNombre());
        obra.setId(null);
        ObrasLiterarias obraguardad = repo.save(obra);
        System.out.println(obraguardad.getId() + obraguardad.getNombre());
        return new MessageDto("Se ha registrado la obra");
    }

    @Override
    public List<ObrasLiterariasDto> searchAllObras() {
        Page<ObrasLiterarias> obrasPage = repo.findAll(Pageable.unpaged()); // Obtener todas las obras sin paginación
        List<ObrasLiterarias> obras = obrasPage.getContent(); // Extraer la lista del Page
        ModelMapper modelMapper = new ModelMapper();
        return obras.stream().map(o-> modelMapper.map(o, ObrasLiterariasDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObrasLiterariasDto> searchAllObrasPorAutor(String autor) {
        List<ObrasLiterarias> obras = repo.buscarPorAutor(autor);
        ModelMapper modelMapper = new ModelMapper();
        return obras.stream().map(o-> modelMapper.map(o, ObrasLiterariasDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObrasLiterariasDto> searchAllObrasPorTitulo(String titulo) {
        List<ObrasLiterarias> obras = repo.buscarPorNombre(titulo);
        ModelMapper modelMapper = new ModelMapper();
        return obras.stream().map(o-> modelMapper.map(o, ObrasLiterariasDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObrasLiterariasDto> searchAllObrasPorAño(int año) {
        List<ObrasLiterarias> obras = repo.findByAnioPublicacionBefore(año);
        ModelMapper modelMapper = new ModelMapper();
        return obras.stream().map(o-> modelMapper.map(o, ObrasLiterariasDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<ObrasLiterariasDto> searchAllObrasPorEditorial(String editorial) {
        List<ObrasLiterarias> obras = repo.findByEditorial(editorial);
        ModelMapper modelMapper = new ModelMapper();
        return obras.stream().map(o-> modelMapper.map(o, ObrasLiterariasDto.class)).collect(Collectors.toList());
    }
}
