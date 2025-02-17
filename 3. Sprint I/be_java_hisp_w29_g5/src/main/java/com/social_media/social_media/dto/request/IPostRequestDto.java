package com.social_media.social_media.dto.request;

import java.time.LocalDate;

public interface IPostRequestDto {
    Long getUser_id();
    LocalDate getDate();
    ProductRequestDto getProduct();
    Integer getCategory();
    Double getPrice();
}
