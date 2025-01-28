package com.social_media.social_media.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.social_media.social_media.dto.request.StockRequestDto;
import com.social_media.social_media.dto.response.StockResponseDto;
import com.social_media.social_media.service.stock.IStockService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stock")
public class StockController {
    private final IStockService stockService;

    @PostMapping("/{postId}")
    public ResponseEntity<StockResponseDto> postStock(@PathVariable Long postId,
            @RequestBody StockRequestDto stockRequestDto) {
        return new ResponseEntity<>(stockService.createStock(postId, stockRequestDto), HttpStatus.CREATED);
    }

}
