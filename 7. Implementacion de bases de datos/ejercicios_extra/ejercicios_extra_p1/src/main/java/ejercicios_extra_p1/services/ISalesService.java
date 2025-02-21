package ejercicios_extra_p1.services;

import java.util.List;

import ejercicios_extra_p1.dtos.DressDto;
import ejercicios_extra_p1.dtos.SaleDto;
import ejercicios_extra_p1.entities.Dress;

public interface ISalesService {

	Long createSale(SaleDto sale_dto);

  List<DressDto> getSaleClothes(Long number);
  
}
