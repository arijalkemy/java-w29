package com.social_media.social_media.service.stock;

import com.social_media.social_media.dto.request.StockRequestDto;
import com.social_media.social_media.dto.response.StockResponseDto;

public interface IStockService {
    StockResponseDto createStock(Long postId, StockRequestDto stockRequestDto);
}
