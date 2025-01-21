package com.example.linktracker.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Link {
    public static Integer classId = 0;
    private Integer id;
    private String url;
    private String password;
    private Integer counter;
}
