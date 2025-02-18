package com.bootcamp.elasticsearchimpl.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private String id;
    private String title;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Author> authorsList;


}
