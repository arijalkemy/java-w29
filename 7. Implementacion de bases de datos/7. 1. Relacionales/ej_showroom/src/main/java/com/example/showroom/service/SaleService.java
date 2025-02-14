package com.example.showroom.service;

import com.example.showroom.dto.ClotheDto;
import com.example.showroom.dto.SaleDto;

import java.time.LocalDate;
import java.util.List;

public interface SaleService {
    List<SaleDto> getSales(LocalDate date);

    void deleteSale(Integer id);

    List<ClotheDto> getClothesBySale(Integer number);

    String createSale(SaleDto saleDto);

    SaleDto updateSale(Integer number, SaleDto saleDto);

    SaleDto getSaleById(Integer id);
}
