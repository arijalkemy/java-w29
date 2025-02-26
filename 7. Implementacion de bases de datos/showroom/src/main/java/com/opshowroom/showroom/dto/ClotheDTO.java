package com.opshowroom.showroom.dto;

import co.elastic.clients.json.JsonpDeserializable;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.opshowroom.showroom.domain.Sale;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClotheDTO {
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer qty;
    private BigDecimal salePrice;

}
