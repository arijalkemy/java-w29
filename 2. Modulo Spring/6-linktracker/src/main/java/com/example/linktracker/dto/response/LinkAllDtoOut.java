package com.example.linktracker.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkAllDtoOut {
    private Integer id;
    private String url;
    private Boolean valid;
    private Integer visitCounter;
}
