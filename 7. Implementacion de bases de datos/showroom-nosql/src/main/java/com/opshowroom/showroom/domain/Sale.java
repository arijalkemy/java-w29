package com.opshowroom.showroom.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;
import java.util.List;


@Setter
@Getter
@Document(indexName = "sales")
public class Sale {
    @Id
    private Long number;
    @Field(type = FieldType.Date, format = DateFormat.date_optional_time)
    private Date date;
    private Long total;
    private String paymentMethod;
    private List<Long> products;
}
