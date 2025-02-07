package com.thiagoschreck.local.melisocial.service;

import com.thiagoschreck.local.melisocial.dto.request.CreatePostDTO;
import com.thiagoschreck.local.melisocial.dto.request.CreateProductDTO;
import com.thiagoschreck.local.melisocial.entity.product.Post;
import com.thiagoschreck.local.melisocial.entity.product.Product;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import com.thiagoschreck.local.melisocial.exception.InvalidOrderValueException;
import com.thiagoschreck.local.melisocial.repository.*;
import com.thiagoschreck.local.melisocial.exception.DiscountMustHaveValidValueException;
import com.thiagoschreck.local.melisocial.exception.HasDiscountMustBeTrueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;

import com.thiagoschreck.local.melisocial.dto.response.FeedPostsDto;
import com.thiagoschreck.local.melisocial.dto.response.PostWithNoPromoAndDiscountDto;
import com.thiagoschreck.local.melisocial.entity.user.Client;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostsServiceTests {
    @Mock
    IPostsRepository postsRepository;
    @Mock
    IUsersRepository usersRepository;
    @Mock
    IProductsRepository productsRepository;
    @InjectMocks
    private PostsServiceImpl postsService;

    @Test
    @DisplayName("Given seller sends valid information When he sends a discounted post Then the post is saved")
    void testSuccessfulUploadOfDiscountedPost() {
        // ARRANGE
        CreateProductDTO productDTO = new CreateProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special edition");
        CreatePostDTO postDTO = new CreatePostDTO(1, LocalDate.now(), productDTO, 100, 1500.50, true, 0.5);

        Seller seller = new Seller("Seller");
        seller.setUserId(1);

        Product product = new Product(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special edition");
        Post post = new Post(0, 1, LocalDate.now(), product, 100, 1500.50, true, 0.5);

        Mockito.when(usersRepository.findSellerById(seller.getUserId())).thenReturn(Optional.of(seller));
        Mockito.when(productsRepository.getById(product.getId())).thenReturn(null);
        Mockito.when(productsRepository.save(any())).thenReturn(product);
        Mockito.when(postsRepository.save(any())).thenReturn(post);
        // ACT
        CreatePostDTO responseDTO = postsService.saveWithDiscount(postDTO);
        // ASSERT
        assertEquals(post.getUserId(), responseDTO.userId());
        assertEquals(post.getDiscount(), responseDTO.discount());
        assertTrue(responseDTO.hasPromo());
    }

    @Test
    @DisplayName("Given seller sends invalid discount information When he sends a discounted post Then DiscountMustHaveValidValueException is thrown")
    void testInvalidDiscountValue() {    // ARRANGE
        CreateProductDTO productDTO = new CreateProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special edition");
        CreatePostDTO postDTO = new CreatePostDTO(1, LocalDate.now(), productDTO, 100, 1500.50, true, 1.2);
        // ACT
        // ASSERT
        assertThrows(DiscountMustHaveValidValueException.class, () -> postsService.saveWithDiscount(postDTO));
    }

    @Test
    @DisplayName("Given seller sends invalid promo flag When he sends a discounted post Then HasDiscountMustBeTrueException is thrown")
    void testInvalidHasPromoValue() {
        // ARRANGE
        CreateProductDTO productDTO = new CreateProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special edition");
        CreatePostDTO postDTO = new CreatePostDTO(1, LocalDate.now(), productDTO, 100, 1500.50, false, 0.5);
        // ACT
        // ASSERT
        assertThrows(HasDiscountMustBeTrueException.class, () -> postsService.saveWithDiscount(postDTO));
    }

    @Test
    void searchPostsByFollowedSellersWithinWeeksAgoOkTest() {
        //Arrange
        Client client = new Client("Mario");
        client.setUserId(0);
        Seller seller1 = new Seller("David");
        Seller seller2 = new Seller("Pedro");
        seller1.setUserId(1);
        seller2.setUserId(2);
        client.followSeller(seller1);
        client.followSeller(seller2);

        Optional<Client> optionalClient = Optional.of(client);

        LocalDate now = LocalDate.now();

        Product product1 = new Product(1,"Motocicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1,  seller1.getUserId(), now, product1, 1, 40.0, false, 8.0);

        LocalDate oneDayAgo = now.minusDays(1);
        Product product2 = new Product(2,"Pepito", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2,  seller2.getUserId(), oneDayAgo, product2, 1, 80.0, false, 6.0);

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        //Act
        when(usersRepository.findClientById(0)).thenReturn(optionalClient);

        when(postsRepository.getAllPostFromSellersWithinWeeksAgo(1, twoWeeksAgo))
                .thenReturn(List.of(post1));
        when(postsRepository.getAllPostFromSellersWithinWeeksAgo(2, twoWeeksAgo))
                .thenReturn(List.of(post2));

        List<FeedPostsDto> actual = postsService.searchPostsByFollowedSellersWithinWeeksAgo(0);
        int actualUserId = actual.getFirst().userId();

        List<Integer> expected = List.of(
                post1.getId(),
                post2.getId()
        );
        List<Integer> actualIds = actual.getFirst().posts().stream()
                .map(PostWithNoPromoAndDiscountDto::userId)
                .toList();
        List<LocalDate> actualDates = actual.getFirst().posts().stream()
                .map(PostWithNoPromoAndDiscountDto::date)
                        .toList();

        List<LocalDate> expectedDates = List.of(
                post1.getDate(),
                post2.getDate()
        );

        //Assert
        assertNotNull(actual);
        assertEquals(0, actualUserId);
        assertEquals(1, actual.size());
        assertEquals(expected, actualIds);
        assertEquals(expectedDates, actualDates);
    }

    @Test
    public void searchPostsByFollowedSellersWithinWeeksAgoOrderAscOkTest() {
        //Arrange
        String order = "date_asc";
        Client client = new Client("Mario");
        client.setUserId(0);
        Seller seller1 = new Seller("David");
        Seller seller2 = new Seller("Pedro");
        seller1.setUserId(1);
        seller2.setUserId(2);
        client.followSeller(seller1);
        client.followSeller(seller2);

        Optional<Client> optionalClient = Optional.of(client);

        LocalDate now = LocalDate.now();

        Product product1 = new Product(1,"Motocicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1,  seller1.getUserId(), now, product1, 1, 40.0, false, 8.0);

        LocalDate oneDayAgo = now.minusDays(1);
        Product product2 = new Product(2,"Pepito", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2,  seller2.getUserId(), oneDayAgo, product2, 1, 80.0, false, 6.0);

        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);

        //Act

        when(usersRepository.findClientById(client.getUserId())).thenReturn(optionalClient);
        when(postsRepository.getAllPostFromSellersWithinWeeksAgoOrderAsc(1, twoWeeksAgo)).thenReturn(
                Stream.of(post1)
        );
        when(postsRepository.getAllPostFromSellersWithinWeeksAgoOrderAsc(2, twoWeeksAgo)).thenReturn(
                Stream.of(post2)
        );

        List<FeedPostsDto> actual = postsService.searchPostsByFollowedSellersWithinWeeksAgoOrder(0, order);

        int actualUserId = actual.getFirst().userId();

        List<Integer> expected = List.of(
                post2.getId(),
                post1.getId()
        );
        List<Integer> actualIds = actual.getFirst().posts().stream()
                .map(PostWithNoPromoAndDiscountDto::userId)
                .toList();
        List<LocalDate> actualDates = actual.getFirst().posts().stream()
                .map(PostWithNoPromoAndDiscountDto::date)
                .toList();

        List<LocalDate> expectedDates = List.of(
                post2.getDate(),
                post1.getDate()
        );

        //Assert
        assertNotNull(actual);
        assertEquals(0, actualUserId);
        assertEquals(1, actual.size());
        assertEquals(expected, actualIds);
        assertEquals(expectedDates, actualDates);
    }

    @Test
    public void searchPostsByFollowedSellersWithinWeeksAgoOrderDescOkTest() {
        //Arrange
        String order = "date_desc";
        Client client = new Client("Mario");
        client.setUserId(0);
        Seller seller1 = new Seller("David");
        Seller seller2 = new Seller("Pedro");
        seller1.setUserId(1);
        seller2.setUserId(2);
        client.followSeller(seller1);
        client.followSeller(seller2);

        Optional<Client> optionalClient = Optional.of(client);

        LocalDate now = LocalDate.now();

        Product product1 = new Product(1,"Motocicleta", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post1 = new Post(1,  seller1.getUserId(), now, product1, 1, 40.0, false, 8.0);

        LocalDate oneDayAgo = now.minusDays(1);
        Product product2 = new Product(2,"Pepito", "Acuatico", "Mercedes","Rojo","Me gusta este producto, comprelo ya!");
        Post post2 = new Post(2,  seller2.getUserId(), oneDayAgo, product2, 1, 80.0, false, 6.0);


        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        //Act
        when(usersRepository.findClientById(client.getUserId())).thenReturn(optionalClient);
        when(postsRepository.getAllPostFromSellersWithinWeeksAgoOrderAsc(1, twoWeeksAgo)).thenReturn(
                Stream.of(post1)
        );
        when(postsRepository.getAllPostFromSellersWithinWeeksAgoOrderAsc(2, twoWeeksAgo)).thenReturn(
                Stream.of(post2)
        );

        List<FeedPostsDto> actual = postsService.searchPostsByFollowedSellersWithinWeeksAgoOrder(client.getUserId(), order);
        int actualUserId = actual.getFirst().userId();

        List<Integer> expected = List.of(
                post1.getId(),
                post2.getId()
        );
        List<Integer> actualIds = actual.getFirst().posts().stream()
                .map(PostWithNoPromoAndDiscountDto::userId)
                .toList();
        List<LocalDate> actualDates = actual.getFirst().posts().stream()
                .map(PostWithNoPromoAndDiscountDto::date)
                .toList();

        List<LocalDate> expectedDates = List.of(
                post1.getDate(),
                post2.getDate()
        );


        //Assert
        assertNotNull(actual);
        assertEquals(0, actualUserId);
        assertEquals(1, actual.size());
        assertEquals(expected, actualIds);
        assertEquals(expectedDates, actualDates);
    }

    @Test
    public void searchPostByFollowedSellersWithinWeeksAgoInvalidOrderThrowsInvalidOrderValueException() {
        //Arrange
        Client client = new Client("Pepe");
        int userId = (int)(Math.random() * 1000);
        client.setUserId(userId);
        Optional<Client> optionalClient = Optional.of(client);
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String order = new String(array, StandardCharsets.UTF_8);

        //Act and Assert
        when(usersRepository.findClientById(client.getUserId())).thenReturn(optionalClient);

        assertThrows(InvalidOrderValueException.class, () -> postsService.searchPostsByFollowedSellersWithinWeeksAgoOrder(userId, order));
    }
}
