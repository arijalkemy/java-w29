package com.bootcamp.manejo_excepciones_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogRequestDTO {
    private Integer blogId;
    private String blogTitle;
    private String authorName;
}
