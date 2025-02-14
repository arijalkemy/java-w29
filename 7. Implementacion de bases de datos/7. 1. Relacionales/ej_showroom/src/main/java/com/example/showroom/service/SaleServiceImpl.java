package com.example.showroom.service;

import com.example.showroom.dto.ClotheDto;
import com.example.showroom.dto.SaleDto;
import com.example.showroom.model.Sale;
import com.example.showroom.repository.ClotheRepository;
import com.example.showroom.repository.SaleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

    private final SaleRepository saleRepository;

    private final ClotheRepository clotheRepository;

    private final ModelMapper mapper;

    @Override
    public List<SaleDto> getSales(LocalDate date) {
        List<Sale> sales;

        if (date != null) {
            sales = saleRepository.findByDate(date);
        } else {
            sales = saleRepository.findAll();
        }

        return sales
                .stream()
                .map(s -> mapper.map(s, SaleDto.class))
                .toList();
    }

    @Override
    public void deleteSale(Integer id) {
        Sale sale = getSaleIfExists(id);
        saleRepository.delete(sale);
    }

    @Override
    public List<ClotheDto> getClothesBySale(Integer number) {
        return clotheRepository.findAllBySaleId(number)
                .stream()
                .map(c -> mapper.map(c, ClotheDto.class))
                .toList();
    }

    @Override
    public String createSale(SaleDto saleDto) {
        Sale sale = mapper.map(saleDto, Sale.class);
        saleRepository.save(sale);
        return String.format("Sale with number %d created", sale.getId());
    }

    @Override
    public SaleDto updateSale(Integer number, SaleDto saleDto) {
        Sale sale = getSaleIfExists(number);
        mapper.map(saleDto, sale);
        saleRepository.save(sale);
        return mapper.map(sale, SaleDto.class);
    }

    @Override
    public SaleDto getSaleById(Integer id) {
        Sale sale = getSaleIfExists(id);
        return mapper.map(sale, SaleDto.class);
    }

    private Sale getSaleIfExists(Integer id) {
        return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
    }
}
