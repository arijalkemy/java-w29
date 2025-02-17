package com.social_media.social_media.service;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.social_media.social_media.TestUtils;
import com.social_media.social_media.dto.request.StockRequestDto;
import com.social_media.social_media.dto.response.PostDetailResponseDto;
import com.social_media.social_media.dto.response.ProductResponseDto;
import com.social_media.social_media.dto.response.StockResponseDto;
import com.social_media.social_media.entity.Post;
import com.social_media.social_media.entity.Product;
import com.social_media.social_media.entity.Stock;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.repository.stock.StockRepository;
import com.social_media.social_media.service.post.PostServiceImpl;
import com.social_media.social_media.service.stock.StockServiceImpl;
import com.social_media.social_media.utils.MessagesExceptions;

@ExtendWith(MockitoExtension.class)
public class T0014 {
    @Mock
    PostRepositoryImpl postRepository;

    @Mock
    StockRepository stockRepository;

    @InjectMocks
    StockServiceImpl stockService;

    @InjectMocks
    PostServiceImpl postService;

    @Test
    @DisplayName("T-0014 Create Stock Test 200")
    void createStockTest200() {
        StockRequestDto requestBodyDto = new StockRequestDto(15L);

        User userSeller = TestUtils.createRandomUser();

        Post post = TestUtils.createRandomPost(userSeller.getUserId());

        when(postRepository.findById(post.getPostId())).thenReturn(Optional.of(post));

        StockResponseDto expectedResponse = new StockResponseDto(15L);
        StockResponseDto actualResponse = stockService.createStock(post.getPostId(), requestBodyDto);

        assertThat(actualResponse)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("T-0014 Post not found exception")
    void createStockFailPostNotFound() {
        StockRequestDto requestBodyDto = new StockRequestDto(15L);

        User userSeller = TestUtils.createRandomUser();

        Post post = TestUtils.createRandomPost(userSeller.getUserId());

        when(postRepository.findById(post.getPostId())).thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> stockService.createStock(post.getPostId(), requestBodyDto));

        String expectedMessage = MessagesExceptions.POST_NOT_FOUND;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("T-0014 Find post with stock Test 200")
    void findPostWithStockTest200() {

        User userSeller = TestUtils.createRandomUser();

        Post post = TestUtils.createRandomPost(userSeller.getUserId());

        Stock stock = new Stock(post.getPostId(), 15L);

        StockResponseDto stockResponseDto = new StockResponseDto(15L);

        Product product = post.getProduct();
        ProductResponseDto productResponseDto = new ProductResponseDto(product.getProductId(), product.getProductName(),
                product.getType(), product.getBrand(), product.getColor(), product.getNotes());

        when(postRepository.findById(post.getPostId())).thenReturn(Optional.of(post));

        when(stockRepository.findByPostId(post.getPostId())).thenReturn(Optional.of(stock));

        PostDetailResponseDto expectedResponse = new PostDetailResponseDto(post.getPostId(), userSeller.getUserId(),
                stockResponseDto, post.getDate(), productResponseDto, post.getCategory(), post.getPrice(), true,
                post.getDiscount());
        PostDetailResponseDto actualResponse = postService.searchById(post.getPostId());

        assertThat(actualResponse)
                .usingRecursiveComparison()
                .isEqualTo(expectedResponse);
    }

    @Test
    @DisplayName("T-0014 Find Post with stock not found exception")
    void findPostWithStockFailPostNotFound() {

        User userSeller = TestUtils.createRandomUser();

        Post post = TestUtils.createRandomPost(userSeller.getUserId());

        when(postRepository.findById(post.getPostId())).thenReturn(Optional.empty());

        NotFoundException thrown = assertThrows(
                NotFoundException.class,
                () -> postService.searchById(post.getPostId()));

        String expectedMessage = MessagesExceptions.POST_NOT_FOUND;
        String actualMessage = thrown.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
