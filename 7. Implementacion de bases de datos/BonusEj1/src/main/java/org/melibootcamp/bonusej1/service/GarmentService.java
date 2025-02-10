package org.melibootcamp.bonusej1.service;

import org.melibootcamp.bonusej1.dto.GarmentDto;
import org.melibootcamp.bonusej1.dto.MessageDto;
import org.melibootcamp.bonusej1.entity.Garment;
import org.melibootcamp.bonusej1.exception.GarmentAlreadyExist;
import org.melibootcamp.bonusej1.exception.GarmentNotFound;
import org.melibootcamp.bonusej1.repository.IGarmentRepository;
import org.melibootcamp.bonusej1.utils.MyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarmentService implements IGarmentService {
    @Autowired
    private IGarmentRepository prendaRepository;


    @Override
    public MessageDto saveGarment(GarmentDto garment) {
        Long id= garment.getId();
        if (prendaRepository.existsById(id)){
            throw new GarmentAlreadyExist("Ya existe Papu");
        }
        prendaRepository.save(MyMapper.garmenDtoToGarment(garment));
        return new MessageDto("Garment Guardada");
    }

    @Override
    public MessageDto updateGarment(GarmentDto garmentDto, Long id) {
        if (prendaRepository.existsById(id)) {
            garmentDto.setId(id);
            prendaRepository.save(MyMapper.garmenDtoToGarment(garmentDto));
            return new MessageDto("Garment updated");
        }
        throw new GarmentNotFound("No se encontro");
    }

    @Override
    public MessageDto deleteGarmentById(Long id) {
        prendaRepository.deleteById(id);
        return new MessageDto("Garment Deleted");
    }
    @Override
    public List<GarmentDto> getAllGarments() {
        List<Garment> garments =prendaRepository.findAll();
        if (garments.isEmpty()) {
            throw new GarmentNotFound("No garments found");
        }
        return garments.stream().map(MyMapper::garmenToGarmentDto).toList();
    }
    @Override
    public GarmentDto getGarmentById(Long id) {
        Optional<Garment> garment = prendaRepository.findPrendasById(id);
        if (garment.isEmpty()) {
            throw new GarmentNotFound("Garment not found");
        }
        return MyMapper.garmenToGarmentDto(garment.get());
    }
    @Override
    public List<GarmentDto> getPrendasBySize(String size){
        List<Garment> garments= prendaRepository.findGarmentBySize(size);
        if (garments.isEmpty()){
            throw new GarmentNotFound("Garment not found");
        }
        return garments.stream().map(MyMapper::garmenToGarmentDto).toList();
    }
    @Override
    public List<GarmentDto> getPrendasByNameContainingIgnoreCase(String name){
        List<Garment> garments= prendaRepository.findGarmentByNameContainingIgnoreCase(name);
        if (garments.isEmpty()){
            throw new GarmentNotFound("Garment not found");
        }
        return garments.stream().map(MyMapper::garmenToGarmentDto).toList();
    }


}
