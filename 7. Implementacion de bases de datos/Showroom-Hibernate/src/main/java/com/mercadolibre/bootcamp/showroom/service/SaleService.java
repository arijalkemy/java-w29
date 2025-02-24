package com.mercadolibre.bootcamp.showroom.service;

import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.dto.MessageDTO;
import com.mercadolibre.bootcamp.showroom.dto.SaleDTO;
import com.mercadolibre.bootcamp.showroom.exception.EntityNotFoundException;
import com.mercadolibre.bootcamp.showroom.mappers.GarmentMapper;
import com.mercadolibre.bootcamp.showroom.mappers.SaleMapper;
import com.mercadolibre.bootcamp.showroom.model.Garment;
import com.mercadolibre.bootcamp.showroom.model.Sale;
import com.mercadolibre.bootcamp.showroom.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public SaleDTO createSale(SaleDTO saleDto) {
        Sale savedSale = saleRepository.save(SaleMapper.toSaleEntity(saleDto));
        return SaleMapper.toSaleDTO(savedSale);
    }

    @Override
    public List<SaleDTO> searchAllSales() {
        return saleRepository
                .findAll()
                .stream()
                .map(SaleMapper::toSaleDTO)
                .toList();
    }

    @Override
    public SaleDTO searchSaleById(Long id) {
        Optional<Sale> optionalSale = saleRepository.findById(id);

        if (optionalSale.isEmpty())
            throw new EntityNotFoundException("Sale not found");

        return SaleMapper.toSaleDTO(optionalSale.get());
    }

    @Override
    public MessageDTO updateSale(Long id, SaleDTO saleDto) {
        Optional<Sale> saleOptional = saleRepository.findById(id);

        if (saleOptional.isEmpty())
            throw new EntityNotFoundException("Sale not found");

        /* Tener en cuenta que el GarmentDetails asociado sigue en la tabla, no se borró. */
        Sale newOne = SaleMapper.toSaleEntity(saleDto);
        newOne.setId(id);

        saleRepository.save(newOne);

        return new MessageDTO("Updated successfully");
    }

    @Override
    public MessageDTO deleteSale(Long id) {
        saleRepository.deleteById(id);
        return new MessageDTO("Deleted successfully");
    }

    @Override
    public List<GarmentDTO> searchGarmentByDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<GarmentDTO> searchGarmentBySaleId(Long saleId) {
        return saleRepository
                .findGarmentBySaleId(saleId)
                .stream()
                .map(GarmentMapper::toGarmentDTO)
                .collect(Collectors.toList());
    }
}
