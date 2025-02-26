package com.opshowroom.showroom.service;

import com.opshowroom.showroom.domain.Sale;
import com.opshowroom.showroom.dto.*;


import java.util.List;

public interface ISaleService {

    Sale createSale(Sale sale);

    List<SaleDTO> getAllSales();

    SaleDTO getSaleByNumber(Long number);

    Sale updateSale(Long number, Sale sale);

    void deleteSale(Long number);

    List<SaleDTO> getSalesByDate(String dateStr);

    List<ClotheDTO> getClothesBySale(Long number);
}
