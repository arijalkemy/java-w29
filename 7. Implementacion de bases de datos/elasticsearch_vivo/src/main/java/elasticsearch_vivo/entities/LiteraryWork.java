package elasticsearch_vivo.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "literary_works")
public class LiteraryWork {
  
  @Id
  private String id;
  private String name;
  private String author;
  private Integer pages;
  private String editorial;
  private LocalDate publication_date;
}
