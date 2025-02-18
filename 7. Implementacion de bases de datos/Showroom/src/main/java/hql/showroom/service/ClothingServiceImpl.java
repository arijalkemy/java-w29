package hql.showroom.service;

import hql.showroom.dto.request.ClothingRequestDTO;
import hql.showroom.dto.response.ClothingResponseDTO;
import hql.showroom.model.Clothing;
import hql.showroom.repository.IClothingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClothingServiceImpl {

    private final IClothingRepository clothingRepository;

    public ClothingServiceImpl(IClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }

    public List<ClothingResponseDTO> getAllClothes() {
        return clothingRepository.findAll()
                .stream()
                .map(ClothingResponseDTO::new)
                .collect(Collectors.toList());
    }

    public ClothingResponseDTO getClothingByCode(String code) {
        Clothing clothing = clothingRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clothing not found"));
        return new ClothingResponseDTO(clothing);
    }

    public ClothingResponseDTO createClothing(ClothingRequestDTO clothingRequest) {
        Clothing clothing = new Clothing();
        clothing.setCode(clothingRequest.getCode());
        clothing.setName(clothingRequest.getName());
        clothing.setType(clothingRequest.getType());
        clothing.setBrand(clothingRequest.getBrand());
        clothing.setColor(clothingRequest.getColor());
        clothing.setSize(clothingRequest.getSize());
        clothing.setQuantity(clothingRequest.getQuantity());
        clothing.setSalePrice(clothingRequest.getSalePrice());

        return new ClothingResponseDTO(clothingRepository.save(clothing));
    }


    public ClothingResponseDTO updateClothing(String code, ClothingRequestDTO updatedClothing) {
        Clothing clothing = clothingRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clothing not found"));

        clothing.setName(updatedClothing.getName());
        clothing.setType(updatedClothing.getType());
        clothing.setBrand(updatedClothing.getBrand());
        clothing.setColor(updatedClothing.getColor());
        clothing.setSize(updatedClothing.getSize());
        clothing.setQuantity(updatedClothing.getQuantity());
        clothing.setSalePrice(updatedClothing.getSalePrice());

        Clothing updated = clothingRepository.save(clothing);
        return new ClothingResponseDTO(updated);
    }


    public void deleteClothing(String code) {
        Clothing clothing = clothingRepository.findByCode(code)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clothing not found"));

        clothingRepository.delete(clothing);
    }

    public List<ClothingResponseDTO> getClothesBySize(String size) {
        List<Clothing> clothes = clothingRepository.findBySize(size);
        return clothes.stream()
                .map(ClothingResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<ClothingResponseDTO> searchClothesByName(String name) {
        List<Clothing> clothes = clothingRepository.findByNameContainingIgnoreCase(name);
        return clothes.stream()
                .map(ClothingResponseDTO::new)
                .collect(Collectors.toList());
    }
}
