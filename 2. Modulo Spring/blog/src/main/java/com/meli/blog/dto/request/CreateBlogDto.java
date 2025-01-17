package com.meli.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlogDto {
    private Integer id;
    private String title;
    private String author;
    private String publishDate;
}
