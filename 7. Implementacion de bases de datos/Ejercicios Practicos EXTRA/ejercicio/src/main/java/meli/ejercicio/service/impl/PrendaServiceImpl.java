package meli.ejercicio.service.impl;

import lombok.RequiredArgsConstructor;
import meli.ejercicio.dto.IdPrendaDto;
import meli.ejercicio.dto.PrendaDTO;
import meli.ejercicio.exceptions.NotFoundException;
import meli.ejercicio.model.Prenda;
import meli.ejercicio.repository.PrendaRepository;
import meli.ejercicio.service.PrendaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrendaServiceImpl implements PrendaService {

    private ModelMapper modelMapper = new ModelMapper();

    private final PrendaRepository prendaRepository;

    @Override
    public IdPrendaDto create(PrendaDTO prendaDTO) {
        Prenda prenda = modelMapper.map(prendaDTO, Prenda.class);
        Prenda prendaSaved = prendaRepository.save(prenda);
        return new IdPrendaDto(prendaSaved.getCodigo());
    }

    @Override
    public List<PrendaDTO> getAll() {
        List<Prenda> prendas = prendaRepository.findAll();
        return prendas.stream()
                .map(prenda -> modelMapper.map(prenda, PrendaDTO.class))
                .toList();
    }

    @Override
    public PrendaDTO getById(Long id) {
        Prenda prenda = prendaRepository.findById(id).orElseThrow(() -> new NotFoundException("Prenda not found"));
        return modelMapper.map(prenda, PrendaDTO.class);
    }

    @Override
    public PrendaDTO update(Long id, PrendaDTO prendaDTO) {
        Prenda prenda = prendaRepository.findById(id).orElseThrow(() -> new NotFoundException("Prenda not found"));
        return modelMapper.map(prendaRepository.save(prenda), PrendaDTO.class);
    }
}
