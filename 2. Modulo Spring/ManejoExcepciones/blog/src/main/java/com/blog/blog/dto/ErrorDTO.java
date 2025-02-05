package com.blog.blog.dto;

import lombok.Data;

@Data
public class ErrorDTO {
    private String error;

    public ErrorDTO(String error) {
        this.error = error;
    }

}
