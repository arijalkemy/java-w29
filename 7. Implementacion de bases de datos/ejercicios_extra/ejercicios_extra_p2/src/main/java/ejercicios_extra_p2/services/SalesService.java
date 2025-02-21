package ejercicios_extra_p2.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import ejercicios_extra_p2.dtos.SaleDto;
import ejercicios_extra_p2.entities.Sale;
import ejercicios_extra_p2.repositories.ISaleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesService implements ISalesService {
  private final ISaleRepository sale_repository;

  @Override
  public String saveSale(SaleDto sale_dto) {
    Sale sale = sale_dto.toSale();
    sale_repository.save(sale);
    return sale.getId();
  }

  @Override
  public List<SaleDto> getSales() {
    return StreamSupport.stream(sale_repository.findAll().spliterator(), true)
      .map(SaleDto::new)
      .toList();
  }

  @Override
  public SaleDto getSaleById(String id) {
    Optional<Sale> sale = sale_repository.findById(id);
    if(sale.isEmpty()) throw new RuntimeException("Sale not found");
    //TODO: Implementar manejo de excepciones
    return new SaleDto(sale_repository.findById(id).get());
  }
  
}
