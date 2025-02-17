package ejercicios.meli.services.impl;

import ejercicios.meli.entity.ObraLitearia;
import ejercicios.meli.repository.ObraLiteariaRepository;
import ejercicios.meli.services.ObraLiterariaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObraLiterariaServiceImpl implements ObraLiterariaService {

    private final ObraLiteariaRepository obraLiteariaRepository;

    @Override
    public ObraLitearia save(ObraLitearia obraLitearia) {
        return obraLiteariaRepository.save(obraLitearia);
    }
}
