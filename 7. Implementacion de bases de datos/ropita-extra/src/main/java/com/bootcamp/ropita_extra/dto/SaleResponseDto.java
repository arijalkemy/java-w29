package com.bootcamp.ropita_extra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SaleResponseDto {
    private LocalDate date;
    private Double total;
    @JsonProperty("payment_method")
    private String paymentMethod;
    private List<ClothesDto> clothes;
}
