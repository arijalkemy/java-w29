package com.bootcamp.shopcart.dto;

import java.util.List;

public record CartResponseBody(
        Long id,
        List<ItemRequestBody> items
) {
}
