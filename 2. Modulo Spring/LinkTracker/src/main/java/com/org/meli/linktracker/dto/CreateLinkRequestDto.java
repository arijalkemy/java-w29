package com.org.meli.linktracker.dto;

import lombok.Data;

@Data
public class CreateLinkRequestDto {
    private String url;
    private String password;
}
