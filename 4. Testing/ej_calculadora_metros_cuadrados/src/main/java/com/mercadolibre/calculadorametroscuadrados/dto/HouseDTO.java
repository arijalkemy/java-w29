package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;
}
