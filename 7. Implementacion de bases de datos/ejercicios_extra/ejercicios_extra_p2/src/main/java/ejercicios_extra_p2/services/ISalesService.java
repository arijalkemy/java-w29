package ejercicios_extra_p2.services;

import java.util.List;

import ejercicios_extra_p2.dtos.SaleDto;

public interface ISalesService {

  String saveSale(SaleDto sale_dto);

  List<SaleDto> getSales();

  SaleDto getSaleById(String id);
  
}
