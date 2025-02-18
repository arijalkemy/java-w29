package ejercicios_extra_p1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ejercicios_extra_p1.dtos.DressDto;
import ejercicios_extra_p1.entities.Dress;
import ejercicios_extra_p1.repositories.IDressRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClothesService implements IClothesService {

  private final IDressRepository dress_repository;

	@Override
	public Long addDress(DressDto dress_request_dto) {
		Dress dress = dress_request_dto.toDress();
    dress_repository.save(dress);
    return dress.getId();
	}

	@Override
	public List<DressDto> getAllDresses(String name) {
    if(name == null) name = "";
		return dress_repository.findAllByNameContainingIgnoreCase(name).stream()
      .map(DressDto::new)
      .toList();
	}

	@Override
	public List<DressDto> getDressByCode(String code) {
    List<Dress> clothes = new ArrayList<>();
    try{
      Long id = Long.parseLong(code);
      Optional<Dress> dress = dress_repository.findById(id);
      if(dress.isPresent()) clothes.add(dress.get());
    } catch (Exception exception){
      clothes = dress_repository.findAllBySize(code);
    }
    return clothes.stream()
      .map(DressDto::new)
      .toList();
	}

	@Override
	public void updateDress(String code, DressDto dress_request_dto) {
    Long id = Long.parseLong(code);
    Optional<Dress> dress = dress_repository.findById(id);
    if(dress.isPresent()){
      Dress updated_dress = dress_request_dto.toDress();
      updated_dress.setId(id);
      dress_repository.save(updated_dress);
    }
	}

	@Override
	public void deleteDress(String code) {
		Long id = Long.parseLong(code);
    dress_repository.deleteById(id);
	}
}
