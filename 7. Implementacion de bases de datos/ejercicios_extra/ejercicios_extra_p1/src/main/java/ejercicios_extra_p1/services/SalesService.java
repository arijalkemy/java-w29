package ejercicios_extra_p1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ejercicios_extra_p1.dtos.DressDto;
import ejercicios_extra_p1.dtos.SaleDto;
import ejercicios_extra_p1.entities.Dress;
import ejercicios_extra_p1.entities.Sale;
import ejercicios_extra_p1.repositories.ISaleRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SalesService implements ISalesService {
  private final ISaleRepository sale_repository;

	@Override
	public Long createSale(SaleDto sale_dto) {
		Sale sale = sale_dto.toSale();
    sale_repository.save(sale);
    return sale.getId();
	}

	@Override
	public List<DressDto> getSaleClothes(Long number) {
		Optional<Sale> sale = sale_repository.findById(number);
    if (sale.isPresent()) {
      return sale.get().getDresses().stream().map(DressDto::new).toList();
    }
    return List.of();
	}
}