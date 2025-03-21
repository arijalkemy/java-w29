package com.mercadolibre.final_project_bootcamp_esp_2.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    @NotNull(message = "Date cannot be null")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date date;

    @NotNull(message = "Buyer ID cannot be null")
    private Integer buyerId;

    @NotNull(message = "Order status cannot be null")
    private OrderStatus orderStatus;

    @NotNull(message = "Product list cannot be null")
    private List<ProductRequestDTO> products;

    public <T> OrderRequestDTO(long l, List<T> list, String date) {
    }
}
