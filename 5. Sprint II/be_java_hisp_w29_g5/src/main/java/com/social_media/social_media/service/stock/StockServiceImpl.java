package com.social_media.social_media.service.stock;

import org.springframework.stereotype.Service;

import com.social_media.social_media.dto.request.StockRequestDto;
import com.social_media.social_media.dto.response.StockResponseDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.Stock;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.post.IPostRepository;
import com.social_media.social_media.repository.stock.IStockRepository;
import com.social_media.social_media.utils.MessagesExceptions;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements IStockService {
    private final IStockRepository stockRepository;
    private final IPostRepository postRepository;

    @Override
    public StockResponseDto createStock(Long postId, StockRequestDto stockRequestDto) {
        Post postFound = postRepository.findById(postId).orElse(null);

        if (postFound == null) {
            throw new NotFoundException(MessagesExceptions.POST_NOT_FOUND);
        }

        Stock newStock = new Stock(postId, stockRequestDto.getUnits());
        stockRepository.add(newStock);

        return StockResponseDto.builder().units(stockRequestDto.getUnits()).build();
    }

}
