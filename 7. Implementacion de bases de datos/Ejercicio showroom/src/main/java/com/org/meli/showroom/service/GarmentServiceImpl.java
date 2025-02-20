package com.org.meli.showroom.service;

import com.org.meli.showroom.dto.GarmentDto;
import com.org.meli.showroom.exception.NotFoundException;
import com.org.meli.showroom.model.Garment;
import com.org.meli.showroom.repository.IGarmentRepository;
import com.org.meli.showroom.util.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GarmentServiceImpl implements IGarmentService {
    private final IGarmentRepository garmentRepository;

    @Override
    public GarmentDto saveGarment(GarmentDto garmentDto) {
        Garment garment = ModelMapperUtil.map(garmentDto, Garment.class);
        garmentRepository.save(garment);
        return ModelMapperUtil.map(garment, GarmentDto.class);
    }

    @Override
    public List<GarmentDto> getAllGarments() {
        return garmentRepository.findAll().stream()
                .map(garment -> ModelMapperUtil.map(garment, GarmentDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public GarmentDto getGarmentById(Long id) {
        Garment garment = garmentRepository.findById(id).orElse(null);
        if (garment == null) {
            throw new NotFoundException("Garment not found");
        }
        return ModelMapperUtil.map(garmentRepository.findById(id).orElse(null), GarmentDto.class);
    }

    @Override
    public GarmentDto updateGarment(Long id, GarmentDto garmentDto) {
        Garment garment = garmentRepository.findById(id).orElse(null);
        if (garment == null) {
            throw new NotFoundException("Garment not found");
        }
        garment.setName(garmentDto.getName());
        garment.setType(garmentDto.getType());
        garment.setBrand(garmentDto.getBrand());
        garment.setColor(garmentDto.getColor());
        garment.setSize(garmentDto.getSize());
        garment.setAmount(garmentDto.getAmount());
        garment.setPrice(garmentDto.getPrice());
        garmentRepository.save(garment);
        return ModelMapperUtil.map(garment, GarmentDto.class);
    }

    @Override
    public GarmentDto deleteGarment(Long id) {
        Garment garment = garmentRepository.findById(id).orElse(null);
        if (garment == null) {
            throw new NotFoundException("Garment not found");
        }
        garmentRepository.delete(garment);
        return ModelMapperUtil.map(garment, GarmentDto.class);
    }

    public List<GarmentDto> getGarmentsBySize(String size) {
        List<Garment> garments = garmentRepository.findGarmentBySizeIgnoreCase(size);
        if (garments.isEmpty()) {
            throw new NotFoundException("Garment not found");
        }
        return garments.stream()
                .map(garment -> ModelMapperUtil.map(garment, GarmentDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<GarmentDto> getGarmentsByName(String name) {
        if (name == null) {
            throw new NotFoundException("Name not found");
        } else if (garmentRepository.findByNameContainingIgnoreCase(name).isEmpty()) {
            throw new NotFoundException("Garment not found");
        }
        return garmentRepository.findByNameContainingIgnoreCase(name).stream()
                .map(garment -> ModelMapperUtil.map(garment, GarmentDto.class))
                .collect(Collectors.toList());
    }
}
