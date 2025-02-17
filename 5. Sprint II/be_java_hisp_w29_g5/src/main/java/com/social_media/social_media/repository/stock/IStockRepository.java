package com.social_media.social_media.repository.stock;

import java.util.Optional;

import com.social_media.social_media.entity.Stock;

public interface IStockRepository {
    Stock add(Stock stock);

    Optional<Stock> findByPostId(Long postId);
}
