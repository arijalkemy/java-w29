package com.org.meli.showroom.service;

import com.org.meli.showroom.dto.GarmentDto;
import com.org.meli.showroom.dto.SaleDto;

import java.util.Date;
import java.util.List;

public interface ISaleService {
    SaleDto saveSale(SaleDto saleDto);
    List<SaleDto> getAllSales();
    SaleDto getSaleByNumber(Long number);
    SaleDto updateSale(Long number, SaleDto saleDto);
    SaleDto deleteSale(Long number);
    List<SaleDto> getSalesByDate(Date date);
    List<GarmentDto> getGarmentsBySaleNumber(Long number);
}
