package exercise.joyeria_perlas.service;

import exercise.joyeria_perlas.dto.request.JoyaRequestDto;
import exercise.joyeria_perlas.entity.Joya;
import exercise.joyeria_perlas.repository.IJoyaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoyaService implements IJoyaService{

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public List<Joya> getAll() {
        return joyaRepository.findAll();
    }

    @Override
    public String save(JoyaRequestDto joyaDto) {
        ModelMapper mapper = new ModelMapper();
        Joya newJoya = mapper.map(joyaDto, Joya.class);
        joyaRepository.save(newJoya);

        return "La joya con el id: " + newJoya.getNro_identificatorio() + " ha sido creada.";
    }

    @Override
    public String remove(Long id) {
        joyaRepository.deleteById(id);
        return "La joya con el id: " + id + " ha sido eliminada.";
    }

    @Override
    public Joya getById(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }

    @Override
    public Joya update(JoyaRequestDto joyaDto, Long id) {
        return null;
    }
}
