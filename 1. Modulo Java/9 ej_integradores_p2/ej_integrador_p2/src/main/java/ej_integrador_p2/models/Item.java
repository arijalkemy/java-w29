package ej_integrador_p2.models;

import lombok.*;

@ToString
@Getter
@AllArgsConstructor
public class Item {
  private Integer code;
  private String name;
  private Integer quantity;
  private Double unitaryPrice;
}
