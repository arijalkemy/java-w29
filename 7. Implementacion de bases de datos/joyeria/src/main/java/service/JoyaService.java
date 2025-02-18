package service;

import model.Joya;
import org.jetbrains.annotations.NotNull;
import repository.IJoyaRepository;

import java.util.List;

public class JoyaService implements IJoyaService {

    private final IJoyaRepository joyaRepository;

    public JoyaService(IJoyaRepository joyaRepository) {
        this.joyaRepository = joyaRepository;
    }

    @Override
    public List<Joya> getAllJoya() {
        return joyaRepository.findAll();
    }

    @Override
    public Joya findJoya(Long id) {
        return joyaRepository.findById(id).orElse(null);
    }

    @Override
    public void saveJoya(Joya joya) {
        joyaRepository.save(joya);
    }

    @Override
    public void deleteJoya(Long id) {
        joyaRepository.deleteById(id);
    }

    @Override
    public Joya updateJoya(Long id, @NotNull Joya joya) {
        Joya joyaResult = this.findJoya(id);
        joyaResult.setMaterial(joya.getMaterial());
        joyaResult.setPeso(joya.getPeso());
        joyaResult.setNombre(joya.getNombre());
        joyaResult.setParticularidad(joya.getParticularidad());
        joyaResult.setPosee_piedra(joya.getPosee_piedra());
        joyaResult.setVentaONo(joya.getVentaONo());
        this.saveJoya(joyaResult);
        return joyaResult;
    }
}
