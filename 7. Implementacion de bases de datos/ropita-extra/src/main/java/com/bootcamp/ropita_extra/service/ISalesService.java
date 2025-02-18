package com.bootcamp.ropita_extra.service;

import com.bootcamp.ropita_extra.dto.ClothesDto;
import com.bootcamp.ropita_extra.dto.SaleRequestDto;
import com.bootcamp.ropita_extra.dto.SaleResponseDto;
import jakarta.validation.Valid;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ISalesService {
    List<SaleResponseDto> findAllSales();

    SaleResponseDto findSaleById(String id);

    void deleteSaleById(String id);

    SaleResponseDto saveSale(@Valid SaleRequestDto saleRequestDto);

    SaleResponseDto updateSale(String id, @Valid SaleRequestDto saleRequestDto);

    List<ClothesDto> findClothesFromSale(String id);
}
