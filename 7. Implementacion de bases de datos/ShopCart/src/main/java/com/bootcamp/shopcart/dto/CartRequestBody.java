package com.bootcamp.shopcart.dto;

import java.util.List;

public record CartRequestBody(
        List<ItemRequestBody> items
) {
}
