package com.org.meli.showroom.service;

import com.org.meli.showroom.dto.GarmentDto;
import com.org.meli.showroom.dto.SaleDto;
import com.org.meli.showroom.exception.NotFoundException;
import com.org.meli.showroom.model.Garment;
import com.org.meli.showroom.model.Sale;
import com.org.meli.showroom.repository.ISaleRepository;
import com.org.meli.showroom.util.ModelMapperUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SaleServiceImpl implements ISaleService {
    private final ISaleRepository saleRepository;

    @Override
    public SaleDto saveSale(SaleDto saleDto) {
        Sale sale = ModelMapperUtil.map(saleDto, Sale.class);
        saleRepository.save(sale);
        return ModelMapperUtil.map(sale, SaleDto.class);
    }

    @Override
    public List<SaleDto> getAllSales() {
        return saleRepository.findAll().stream()
                .map(sale -> ModelMapperUtil.map(sale, SaleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaleDto getSaleByNumber(Long number) {
        Sale sale = saleRepository.findById(number).orElse(null);
        if (sale == null) {
            throw new NotFoundException("Sale not found");
        }
        return ModelMapperUtil.map(sale, SaleDto.class);
    }

    @Override
    public SaleDto updateSale(Long number, SaleDto saleDto) {
        Sale sale = saleRepository.findById(number).orElse(null);
        if (sale == null) {
            throw new NotFoundException("Sale not found");
        }
        sale.setDate(saleDto.getDate());
        sale.setTotal(saleDto.getTotal());
        sale.setPaymentMethod(saleDto.getPaymentMethod());
        sale.setGarments(saleDto.getGarments().stream()
                .map(garmentDto -> ModelMapperUtil.map(garmentDto, Garment.class))
                .collect(Collectors.toList()));
        saleRepository.save(sale);
        return ModelMapperUtil.map(sale, SaleDto.class);
    }

    @Override
    public SaleDto deleteSale(Long number) {
        Sale sale = saleRepository.findById(number).orElse(null);
        if (sale == null) {
            throw new NotFoundException("Sale not found");
        }
        SaleDto saleDto = ModelMapperUtil.map(sale, SaleDto.class);
        saleRepository.delete(sale);
        return saleDto;
    }

    @Override
    public List<SaleDto> getSalesByDate(Date date) {
        return saleRepository.findByDate(date).stream()
                .map(sale -> ModelMapperUtil.map(sale, SaleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<GarmentDto> getGarmentsBySaleNumber(Long number) {
        Sale sale = saleRepository.findById(number).orElse(null);
        if (sale == null) {
            throw new NotFoundException("Sale not found");
        }
        return sale.getGarments().stream()
                .map(garment -> ModelMapperUtil.map(garment, GarmentDto.class))
                .collect(Collectors.toList());
    }
}
