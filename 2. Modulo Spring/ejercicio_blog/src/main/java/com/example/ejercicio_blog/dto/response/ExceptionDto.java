package com.example.ejercicio_blog.dto.response;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionDto {
    private String message;
}
