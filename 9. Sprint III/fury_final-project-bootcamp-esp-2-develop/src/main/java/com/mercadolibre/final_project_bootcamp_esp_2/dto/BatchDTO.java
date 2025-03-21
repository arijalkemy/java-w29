package com.mercadolibre.final_project_bootcamp_esp_2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchDTO {
    private Integer batch_number;
    private Integer product_id;
    private Integer product_type_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate due_date;
    private Integer current_quantity;
}
