package com.exceptions.mr_beast.dto;

import lombok.Data;

public record BlogEntryDto(
        Integer id,
        String title,
        String author
) {
}
