package com.bootcamp.be_java_hisp_w29_g3.dto.response;
import com.bootcamp.be_java_hisp_w29_g3.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductFilterDto {
    private Integer sellerId;
    private String sellerName;
    private Product product;
    private Double price;
}
