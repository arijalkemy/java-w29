package ejercicios_extra_p2.entities;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "sales")
public class Sale {

  @Id
  private String id;
  
  @Field(type = FieldType.Date)
  private LocalDate date;
  private Double total;
  private String payment_method;

  @Field(
    type = FieldType.Nested,
    includeInParent = true
  )
  private Set<Dress> dresses;
}
