package com.mercadolibre.final_project_bootcamp_esp_32.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.final_project_bootcamp_esp_32.dtos.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class ResponseProductDTO {
    @JsonProperty("products")
    List<ProductDTO> productDTOList;
}
