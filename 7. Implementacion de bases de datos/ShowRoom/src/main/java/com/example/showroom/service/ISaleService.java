package com.example.showroom.service;

import com.example.showroom.model.dto.SaleDTO;

import java.util.List;

public interface ISaleService {
    SaleDTO createSale(SaleDTO saleDTO);
    SaleDTO getSale(Long number);
    List<SaleDTO> getSales();
    SaleDTO updateSale(SaleDTO saleDTO, Long number);
    void deleteSale(Long number);
}
