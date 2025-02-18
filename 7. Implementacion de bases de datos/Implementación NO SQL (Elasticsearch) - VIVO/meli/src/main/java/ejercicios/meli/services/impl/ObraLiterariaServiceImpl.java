package ejercicios.meli.services.impl;

import ejercicios.meli.entity.ObraLitearia;
import ejercicios.meli.repository.ObraLiteariaRepository;
import ejercicios.meli.services.ObraLiterariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObraLiterariaServiceImpl implements ObraLiterariaService {

    private final ObraLiteariaRepository obraLiteariaRepository;

    @Override
    public ObraLitearia save(ObraLitearia obraLitearia) {
        return obraLiteariaRepository.save(obraLitearia);
    }

    @Override
    public List<ObraLitearia> getByAutor(String autor) {
        return obraLiteariaRepository.findByAutor(autor);
    }

    @Override
    public List<ObraLitearia> getByNombre(String nombre) {
        return obraLiteariaRepository.findByNombre(nombre);
    }

    @Override
    public List<ObraLitearia> getTop5ObrasLiterarias() {
        return obraLiteariaRepository.findTop5ByOrderByCantidadPaginasDesc();
    }

    @Override
    public List<ObraLitearia> getByBeforeThanAnio(Integer anio) {
        return obraLiteariaRepository.findByAnioPublicacionBefore(anio);
    }

    @Override
    public List<ObraLitearia> getByEditorial(String editorial) {
        return obraLiteariaRepository.findByEditorial(editorial);
    }
}
