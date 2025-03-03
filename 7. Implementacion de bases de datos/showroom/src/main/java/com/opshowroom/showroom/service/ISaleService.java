package com.opshowroom.showroom.service;

import com.opshowroom.showroom.domain.Sale;
import com.opshowroom.showroom.dto.request.ClotheDTO;
import com.opshowroom.showroom.dto.request.SaleDTO;
import com.opshowroom.showroom.dto.response.SaleResDTO;


import java.util.List;

public interface ISaleService {

    SaleResDTO createSale(SaleDTO saleDto);

    List<Sale> getAllSales();

    SaleResDTO getSaleById(Long number);

    SaleResDTO updateSale(Long number, SaleDTO saleDto);

    void deleteSale(Long number);

    List<SaleResDTO> getSalesByDate(String dateStr);

    List<ClotheDTO> getClothesBySale(Long number);
}
