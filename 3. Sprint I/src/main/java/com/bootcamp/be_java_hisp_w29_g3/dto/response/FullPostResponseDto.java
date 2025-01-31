package com.bootcamp.be_java_hisp_w29_g3.dto.response;

import com.bootcamp.be_java_hisp_w29_g3.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FullPostResponseDto implements PostResponseDto {
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean hasProm;
    private Double discount;
}
