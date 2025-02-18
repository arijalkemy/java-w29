package ejercicios_extra_p1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dresses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dress {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String type;
  private String brand;
  private String color;
  private String size;
  private String amount;
  private Double price;
  
}
