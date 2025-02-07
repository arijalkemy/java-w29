package com.thiagoschreck.local.melisocial.controller;

import com.thiagoschreck.local.melisocial.dto.request.CreatePostDTO;
import com.thiagoschreck.local.melisocial.dto.response.FeedPostsDto;
import com.thiagoschreck.local.melisocial.dto.response.PostWithNoPromoAndDiscountDto;
import com.thiagoschreck.local.melisocial.dto.response.PromoPostsCountDTO;
import com.thiagoschreck.local.melisocial.entity.product.Post;
import com.thiagoschreck.local.melisocial.entity.product.Product;
import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import com.thiagoschreck.local.melisocial.service.IPostsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductsControllerTests {
    @Mock
    private IPostsService postsService;
    @InjectMocks
    private ProductsController productsController;

    @Test
    void getAllPostsByFollowedSellersWithinTwoWeeksOkTest() {
        //Arrange
        Client client = new Client("Pepe");
        client.setUserId(0);
        Seller seller1 = new Seller("David");
        Seller seller2 = new Seller("Pedro");
        seller1.setUserId(1);
        seller2.setUserId(2);
        client.followSeller(seller1);
        client.followSeller(seller2);

        LocalDate now = LocalDate.now();

        Product product1 = new Product(1, "Motocicleta", "Acuatico", "Mercedes", "Rojo",
                "Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1, seller1.getUserId(), now, product1, 1, 40.0, false, 8.0);

        LocalDate oneDayAgo = now.minusDays(1);
        Product product2 = new Product(2, "Pepito", "Acuatico", "Mercedes", "Rojo",
                "Me gusta este producto, comprelo ya!");

        Post post2 = new Post(2, seller2.getUserId(), oneDayAgo, product2, 1, 80.0, false, 6.0);

        List<PostWithNoPromoAndDiscountDto> posts = List.of(
                new PostWithNoPromoAndDiscountDto(post2.getUserId(), post2.getId(), post2.getDate(),
                        post2.getProduct().getId(), post2.getProduct().getName(), post2.getProduct().getType(),
                        post2.getProduct().getBrand(), post2.getProduct().getColor(), post2.getProduct().getNotes(),
                        post2.getCategory(), post2.getPrice()),
                new PostWithNoPromoAndDiscountDto(post1.getUserId(), post1.getId(), post1.getDate(),
                        post1.getProduct().getId(), post1.getProduct().getName(), post1.getProduct().getType(),
                        post1.getProduct().getBrand(), post1.getProduct().getColor(), post1.getProduct().getNotes(),
                        post1.getCategory(), post1.getPrice())

        );
        FeedPostsDto feedPostsDto = new FeedPostsDto(0, posts);
        List<FeedPostsDto> feed = List.of(
                feedPostsDto
        );

        ResponseEntity<List<FeedPostsDto>> expected = new ResponseEntity<>(feed, HttpStatus.OK);

        //Act
        when(postsService.searchPostsByFollowedSellersWithinWeeksAgo(0)).thenReturn(feed);

        ResponseEntity<List<FeedPostsDto>> actual = productsController.getAllPostsByFollowedSellerWithinTwoWeeks(0);

        //Assert
        assertEquals(expected, actual);
        verify(postsService, times(1)).searchPostsByFollowedSellersWithinWeeksAgo(0);
    }

    @Test
    void getAllPostsByFollowedSellersWithinTwoWeeksOkTestOrder() {
        //Arrange
        String orderAsc = "order_asc";
        Client client = new Client("Pepe");
        client.setUserId(0);
        Seller seller1 = new Seller("David");
        Seller seller2 = new Seller("Pedro");
        seller1.setUserId(1);
        seller2.setUserId(2);
        client.followSeller(seller1);
        client.followSeller(seller2);

        LocalDate now = LocalDate.now();

        Product product1 = new Product(1, "Motocicleta", "Acuatico", "Mercedes", "Rojo",
                "Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1, seller1.getUserId(), now, product1, 1, 40.0, false, 8.0);

        LocalDate oneDayAgo = now.minusDays(1);
        Product product2 = new Product(2, "Pepito", "Acuatico", "Mercedes", "Rojo",
                "Me gusta este producto, comprelo ya!");

        Post post2 = new Post(2, seller2.getUserId(), oneDayAgo, product2, 1, 80.0, false, 6.0);

        List<PostWithNoPromoAndDiscountDto> posts = List.of(
                new PostWithNoPromoAndDiscountDto(post1.getUserId(), post1.getId(), post1.getDate(),
                        post1.getProduct().getId(), post1.getProduct().getName(), post1.getProduct().getType(),
                        post1.getProduct().getBrand(), post1.getProduct().getColor(), post1.getProduct().getNotes(),
                        post1.getCategory(), post1.getPrice()),
                new PostWithNoPromoAndDiscountDto(post2.getUserId(), post2.getId(), post2.getDate(),
                        post2.getProduct().getId(), post2.getProduct().getName(), post2.getProduct().getType(),
                        post2.getProduct().getBrand(), post2.getProduct().getColor(), post2.getProduct().getNotes(),
                        post2.getCategory(), post2.getPrice())

        );
        FeedPostsDto feedPostsDto = new FeedPostsDto(0, posts);
        List<FeedPostsDto> feed = List.of(
                feedPostsDto
        );

        ResponseEntity<List<FeedPostsDto>> expected = new ResponseEntity<>(feed, HttpStatus.OK);

        //Act
        when(postsService.searchPostsByFollowedSellersWithinWeeksAgoOrder(client.getUserId(), orderAsc)).thenReturn(
                feed);

        ResponseEntity<List<FeedPostsDto>> actual = productsController.getAllPostsByFollowedSellerWithinTwoWeeksOrder(0,
                orderAsc);

        //Assert
        assertEquals(expected, actual);
        verify(postsService, times(1)).searchPostsByFollowedSellersWithinWeeksAgoOrder(0, orderAsc);
    }

    @Test
    void createPost() {
        CreatePostDTO request = mock();
        when(postsService.saveWithoutDiscount(request)).thenReturn(request);

        productsController.create(request);

        verify(postsService, times(1)).saveWithoutDiscount(request);
    }

    @Test
    void createDiscountedPost() {
        CreatePostDTO request = mock();
        when(postsService.saveWithDiscount(request)).thenReturn(request);

        productsController.createDiscountedPost(request);

        verify(postsService, times(1)).saveWithDiscount(request);
    }

    @Test
    void getCountProductsWithDiscount() {
        int userId = 0;
        when(postsService.getPromoPostsCountFromSeller(userId))
                .thenReturn(new PromoPostsCountDTO(userId, "Johnny_Test", 10L));

        productsController.getCountProductsWithDiscount(userId);

        verify(postsService, times(1)).getPromoPostsCountFromSeller(userId);
    }
}
