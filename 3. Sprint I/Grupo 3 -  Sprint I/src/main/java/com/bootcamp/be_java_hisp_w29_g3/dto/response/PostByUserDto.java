package com.bootcamp.be_java_hisp_w29_g3.dto.response;


import com.bootcamp.be_java_hisp_w29_g3.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostByUserDto {
    private Integer userId;
    private Integer postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;
}
