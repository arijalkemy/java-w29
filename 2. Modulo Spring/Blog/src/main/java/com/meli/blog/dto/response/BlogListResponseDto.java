package com.meli.blog.dto.response;

import com.meli.blog.dto.BlogDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BlogListResponseDto {
    private List<BlogDto> blogs;
    private String codeResponse;
}
