package ejercicios_extra_p1.services;

import java.util.List;

import ejercicios_extra_p1.dtos.DressDto;

public interface IClothesService {
  Long addDress(DressDto dress_request_dto);
  List<DressDto> getAllDresses(String name);
  List<DressDto> getDressByCode(String code);
	void updateDress(String code, DressDto dress_request_dto);
  void deleteDress(String code);
}
