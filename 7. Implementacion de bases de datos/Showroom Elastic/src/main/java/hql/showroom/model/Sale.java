package hql.showroom.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Document(indexName = "sales_index")  // ✅ Indicar que Sale es un documento de Elasticsearch
public class Sale {

    @Id
    private String id; // Elasticsearch usa String para el ID

    @Field(type = FieldType.Text)
    private String number;

    @Field(type = FieldType.Date)
    private LocalDate date;

    @Field(type = FieldType.Double)
    private Double total;

    @Field(type = FieldType.Text)
    private String paymentMethod;

    @Field(type = FieldType.Nested)  // ✅ Indicar que Clothing es una lista de objetos anidados
    private List<Clothing> clothingList;
}
