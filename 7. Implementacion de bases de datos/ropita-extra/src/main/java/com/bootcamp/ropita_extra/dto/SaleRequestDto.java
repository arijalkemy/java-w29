package com.bootcamp.ropita_extra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class SaleRequestDto {
    @JsonProperty("payment_method")
    private String paymentMethod;
    private List<ClothesDto> clothes;
}
