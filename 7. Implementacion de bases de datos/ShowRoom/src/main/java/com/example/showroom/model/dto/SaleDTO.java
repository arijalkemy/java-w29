package com.example.showroom.model.dto;

import com.example.showroom.model.entity.Clothe;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
public class SaleDTO {
    private Long number;
    private Date date;
    private Double total;
    @JsonProperty("payment_method")
    private String paymentMethod;
    private List<ClotheDTO> clothes;
}
