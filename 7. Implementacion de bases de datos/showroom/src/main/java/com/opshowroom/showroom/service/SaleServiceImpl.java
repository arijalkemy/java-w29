package com.opshowroom.showroom.service;

import com.opshowroom.showroom.domain.Sale;
import com.opshowroom.showroom.dto.ClotheDTO;
import com.opshowroom.showroom.dto.SaleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements ISaleService{
    @Override
    public Sale createSale(Sale sale) {
        return null;
    }

    @Override
    public List<SaleDTO> getAllSales() {
        return List.of();
    }

    @Override
    public SaleDTO getSaleByNumber(Long number) {
        return null;
    }

    @Override
    public Sale updateSale(Long number, Sale sale) {
        return null;
    }

    @Override
    public void deleteSale(Long number) {

    }

    @Override
    public List<SaleDTO> getSalesByDate(String dateStr) {
        return List.of();
    }

    @Override
    public List<ClotheDTO> getClothesBySale(Long number) {
        return List.of();
    }
}
