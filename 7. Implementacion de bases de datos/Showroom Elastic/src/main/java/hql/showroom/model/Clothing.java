package hql.showroom.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(indexName = "clothing_index") // ✅ Indicar que Clothing es un documento en Elasticsearch
public class Clothing {

    @Id
    private String id; // Elasticsearch usa String para IDs

    @Field(type = FieldType.Text)  // ✅ Indicar que es un campo de texto
    private String code;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String type;

    @Field(type = FieldType.Text)
    private String brand;

    @Field(type = FieldType.Text)
    private String color;

    @Field(type = FieldType.Text)
    private String size;

    @Field(type = FieldType.Integer)
    private Integer quantity;

    @Field(type = FieldType.Double)
    private Double salePrice;
}
