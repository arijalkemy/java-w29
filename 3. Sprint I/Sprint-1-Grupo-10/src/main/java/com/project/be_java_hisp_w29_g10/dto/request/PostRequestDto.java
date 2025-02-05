package com.project.be_java_hisp_w29_g10.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostRequestDto {
    private Long user_id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;

    private Integer category;
    private Double price;
    private ProductRequestDto product;

    @Builder.Default
    private Double discount = 0.0;

    @Builder.Default
    private Boolean has_promo = false;

}
