package com.org.meli.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {
    @Getter
    private Long number;
    private Date date;
    private Double total;
    private String paymentMethod;
    private List<GarmentDto> garments;
}
