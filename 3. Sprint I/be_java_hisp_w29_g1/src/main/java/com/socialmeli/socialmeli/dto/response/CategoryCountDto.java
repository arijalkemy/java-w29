package com.socialmeli.socialmeli.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryCountDto {
    private Integer category;

    private Integer count;
}
