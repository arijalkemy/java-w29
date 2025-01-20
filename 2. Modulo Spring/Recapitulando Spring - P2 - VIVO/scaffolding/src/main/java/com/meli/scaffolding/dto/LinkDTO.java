package com.meli.scaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDTO {
  private Integer linkId;
  private String link;
  private String password;
  private Integer contador;
  public void sumarContador() {
    contador++;
  }
}