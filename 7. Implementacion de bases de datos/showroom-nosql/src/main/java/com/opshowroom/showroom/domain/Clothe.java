package com.opshowroom.showroom.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Setter
@Getter
@Document(indexName = "clothes")
public class Clothe {
    @Id
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer qty;
    private Long salePrice;
}
