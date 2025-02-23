package com.example.showroom.utils.mappers;

import com.example.showroom.model.dto.SaleDTO;
import com.example.showroom.model.entity.Sale;

import java.util.List;

public class SaleMapper {
    public static Sale toSale(SaleDTO saleDTO) {
        return Sale.builder()
                .number(saleDTO.getNumber())
                .date(saleDTO.getDate())
                .total(saleDTO.getTotal())
                .paymentMethod(saleDTO.getPaymentMethod())
                .clothes(ClotheMapper.toClotheList(saleDTO.getClothes()))
                .build();
    }

    public static SaleDTO toSaleDTO(Sale sale) {
        return SaleDTO.builder()
                .number(sale.getNumber())
                .date(sale.getDate())
                .total(sale.getTotal())
                .paymentMethod(sale.getPaymentMethod())
                .clothes(ClotheMapper.toClotheDTOList(sale.getClothes()))
                .build();
    }

    public static List<SaleDTO> toSaleDTOList(List<Sale> sales) {
        return sales.stream().map(SaleMapper::toSaleDTO).toList();
    }
}
