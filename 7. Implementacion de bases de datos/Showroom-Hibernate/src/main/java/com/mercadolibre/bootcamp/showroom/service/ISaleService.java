package com.mercadolibre.bootcamp.showroom.service;


import com.mercadolibre.bootcamp.showroom.dto.GarmentDTO;
import com.mercadolibre.bootcamp.showroom.dto.MessageDTO;
import com.mercadolibre.bootcamp.showroom.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz que define las operaciones disponibles para el servicio de ventas
 */
public interface ISaleService {

    SaleDTO createSale(SaleDTO sale);
    List<SaleDTO> searchAllSales();
    SaleDTO searchSaleById(Long id);
    MessageDTO updateSale(Long id, SaleDTO saleDetails);
    MessageDTO deleteSale(Long id);
    List<GarmentDTO> searchGarmentByDate(LocalDate date);
    List<GarmentDTO> searchGarmentBySaleId(Long saleId);
}
