package com.mercadolibre.bootcamp.showroom.service;

import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.dto.MessageDTO;
import com.mercadolibre.bootcamp.showroom.exception.EntityNotFoundException;
import com.mercadolibre.bootcamp.showroom.mappers.GarmentMapper;
import com.mercadolibre.bootcamp.showroom.model.Garment;
import com.mercadolibre.bootcamp.showroom.repository.GarmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GarmentService implements IGarmentService {

    private final GarmentRepository garmentRepository;

    public GarmentService(GarmentRepository garmentRepository) {
        this.garmentRepository = garmentRepository;
    }

    @Override
    public MessageDTO save(GarmentDTO garmentDTO) {
        Garment garment = GarmentMapper.toGarmentEntity(garmentDTO);
        garmentRepository.save(garment);
        return new MessageDTO("Saved");
    }

    @Override
    public List<GarmentDTO> searchAll(String name, Integer size) {
        return garmentRepository.searchAll(name, size)
                .stream()
                .map(GarmentMapper::toGarmentDTO)
                .collect(Collectors.toList());
    }

    public GarmentDTO searchById(Long id) {
        Optional<Garment> garmentOptional = garmentRepository.findById(id);

        if (garmentOptional.isEmpty())
            throw new EntityNotFoundException("Garment not found");

        return GarmentMapper.toGarmentDTO(garmentOptional.get());
    }

    public void updateById(Long id, GarmentDTO garmentDTO) {
        Optional<Garment> garmentOptional = garmentRepository.findById(id);

        if (garmentOptional.isEmpty())
            throw new EntityNotFoundException("Garment not found");

        /* Tener en cuenta que el GarmentDetails asociado sigue en la tabla, no se borró. */
        Garment newOne = GarmentMapper.toGarmentEntity(garmentDTO);
        newOne.setId(id);

        garmentRepository.save(newOne);
    }

    @Override
    public MessageDTO deleteById(Long id) {
        garmentRepository.deleteById(id);
        return new MessageDTO("Garment deleted");
    }

}
