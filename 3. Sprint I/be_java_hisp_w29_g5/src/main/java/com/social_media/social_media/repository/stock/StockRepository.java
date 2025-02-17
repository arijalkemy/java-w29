package com.social_media.social_media.repository.stock;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.stereotype.Repository;

import com.social_media.social_media.entity.Stock;

@Repository
public class StockRepository implements IStockRepository {
    private Map<UUID, Stock> stocks = new HashMap<>();

    @Override
    public Stock add(Stock stock) {
        stocks.put(UUID.randomUUID(), stock);
        return stock;
    }

    @Override
    public Optional<Stock> findByPostId(Long postId) {
        AtomicReference<Stock> stockFoundReference = new AtomicReference<>();
        stocks.forEach((__, stock) -> {
            if (stock.getPostId().equals(postId)) {
                stockFoundReference.set(stock);
            }
        });

        return Optional.ofNullable(stockFoundReference.get());
    }

}
