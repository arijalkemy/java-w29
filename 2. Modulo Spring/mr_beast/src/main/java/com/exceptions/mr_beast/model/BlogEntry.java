package com.exceptions.mr_beast.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class BlogEntry {
    private Integer id;
    private String title;
    private String author;
    private LocalDate date;
}
