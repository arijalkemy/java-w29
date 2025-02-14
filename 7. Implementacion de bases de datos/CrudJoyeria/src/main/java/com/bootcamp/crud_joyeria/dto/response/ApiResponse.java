package com.bootcamp.crud_joyeria.dto.response;

public record ApiResponse<T>(
        T details
) {
}
