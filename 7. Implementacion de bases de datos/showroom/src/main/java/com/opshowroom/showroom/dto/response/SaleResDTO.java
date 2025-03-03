package com.opshowroom.showroom.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.opshowroom.showroom.domain.Clothe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResDTO {
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Long total;
    @JsonProperty("payment_method")
    private String paymentMethod;
    private List<Clothe> products;
}