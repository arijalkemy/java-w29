package com.example.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleDto {
    private LocalDate date;

    @JsonProperty("payment_method")
    private String paymentMethod;

    private Double total;

    @JsonProperty("sale_details")
    private List<SaleDetailDto> saleDetails;
}
