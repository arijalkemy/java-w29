package com.opshowroom.showroom.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ClotheDTO {
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    @JsonProperty("quantity")
    private Integer qty;
    @JsonProperty("sale_price")
    private Long salePrice;
}
