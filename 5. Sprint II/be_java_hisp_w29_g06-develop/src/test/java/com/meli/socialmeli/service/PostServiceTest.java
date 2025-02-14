package com.meli.socialmeli.service;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.meli.socialmeli.constants.PostOrder;
import com.meli.socialmeli.dto.PostDto;
import com.meli.socialmeli.dto.ProductDto;
import com.meli.socialmeli.dto.response.PostFromFollowedDto;
import com.meli.socialmeli.entity.Post;
import com.meli.socialmeli.entity.Product;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import com.meli.socialmeli.exception.NoSellersFollowedException;
import com.meli.socialmeli.exception.NotFoundException;
import com.meli.socialmeli.exception.NotFoundOrderException;
import com.meli.socialmeli.repository.PostRepositoryImpl;
import com.meli.socialmeli.repository.UserRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    private static final int USER_ID = 1;
    private static final int ORDER = 1;
    private static final LocalDate CURRENT_DATE = LocalDate.now();

    @Mock
    PostRepositoryImpl postRepository;
    @Mock
    UserRepositoryImpl userRepository;

    @InjectMocks
    PostServiceImpl postService;

    private List<Seller> sellers;
    private List<Product> products;
    private List<Post> posts;
    private User testUser;
    private Post post1;
    private Seller seller1;
    private Product product1;

    @BeforeEach
    void setUp() {
        sellers = createSellers();
        products = createProducts();
        posts = createPosts();
        testUser = createTestUser();
        seller1 = createTestSeller();
        product1 = createTestProduct();
        post1 = createTestPost(product1, seller1);
    }

    @Test
    @DisplayName("T-0005: Should throw NotFoundOrderException when order is not valid")
    void getPostsFromFollowedUsers_OrderNotFoundException() {
        //Arrange
        Integer order = 0; //incorrecto
        when(userRepository.getById(USER_ID)).thenReturn(Optional.of(testUser));

        //Act & Assert
        assertThrows(NotFoundOrderException.class,
                () -> postService.getPostsFromFollowedUsers(USER_ID, order));
    }

    @Test
    @DisplayName("T-0005: Should return a list of posts from followed users")
    void getPostsFromFollowedUsers_Ok() {
        //Arrange
        when(userRepository.getById(USER_ID)).thenReturn(Optional.of(testUser));
        when(postRepository.getPostsBySellers(testUser.getFollows())).thenReturn(List.of(post1));

        //Act
        PostFromFollowedDto response = postService.getPostsFromFollowedUsers(USER_ID, ORDER);

        //Assert
        verify(userRepository).getById(USER_ID);
        verify(postRepository).getPostsBySellers(testUser.getFollows());
        assert(response.getPosts().size() > 0); //Al menos 1 post
    }

    @Test
    @DisplayName("T-0006: Check that order is correct")
    void getPostsFromFollowedUsersOkOrder() {
        // Arrange
        when(userRepository.getById(USER_ID)).thenReturn(Optional.of(testUser));
        when(postRepository.getPostsBySellers(testUser.getFollows())).thenReturn(posts);

        Comparator<Post> comparator_asc = getPostOrder(1).getComparator();
        Comparator<Post> comparator_desc = getPostOrder(2).getComparator();
        List<Post> postsOrderedAsc = posts;
        postsOrderedAsc = postsOrderedAsc.stream().sorted(comparator_asc).toList();
        List<Post> postsOrderedDesc = posts;
        postsOrderedDesc = postsOrderedDesc.stream().sorted(comparator_desc).toList();
        List<PostDto> postDtoListAsc = createPostsDtosBeforeTwoWeeks(postsOrderedAsc);
        List<PostDto> postDtoListDesc = createPostsDtosBeforeTwoWeeks(postsOrderedDesc);

        
        PostFromFollowedDto expectedAsc = PostFromFollowedDto.builder()
                                                             .userId(USER_ID)
                                                             .posts(postDtoListAsc)
                                                             .build();
        PostFromFollowedDto expectedDesc = PostFromFollowedDto.builder()
                                                              .userId(USER_ID)
                                                              .posts(postDtoListDesc)
                                                              .build();
        // Act
        PostFromFollowedDto resultAsc  = postService.getPostsFromFollowedUsers(USER_ID, 1);
        PostFromFollowedDto resultDesc = postService.getPostsFromFollowedUsers(USER_ID, 2);

        // Assert
        Assertions.assertEquals(expectedAsc, resultAsc);
        Assertions.assertEquals(expectedDesc, resultDesc);
        
        
    }

    @Test
    @DisplayName("T-0008: Should filter posts by last two weeks")
    void getPostsFromFollowedUsersOk() {
        // Arrange
        when(userRepository.getById(USER_ID)).thenReturn(Optional.of(testUser));
        when(postRepository.getPostsBySellers(sellers)).thenReturn(posts);

        // Act
        PostFromFollowedDto result = postService.getPostsFromFollowedUsers(USER_ID, ORDER);

        // Assert
        result.getPosts().forEach(post ->
                Assertions.assertTrue(post.getDate().isAfter(CURRENT_DATE.minusWeeks(2)),
                        "Post date should be within last two weeks")
        );
    }

    @Test
    @DisplayName("T-0008: Not found posts")
    void getPostsFromFollowedUsersExceptionPostsNotFound() {
        // Arrange
        when(userRepository.getById(USER_ID)).thenReturn(Optional.of(testUser));
        when(postRepository.getPostsBySellers(sellers)).thenReturn(Arrays.asList());

        // Act && Assert NotFoundException
        Assertions.assertThrows(NotFoundException.class, () -> postService.getPostsFromFollowedUsers(USER_ID, ORDER));

    }

    @Test
    @DisplayName("T-0008: Not found user")
    void getPostsFromFollowedUsersExceptionUserNotFound() {
        // Arrange
        when(userRepository.getById(USER_ID)).thenReturn(Optional.empty());

        // Act && Assert NotFoundException
        Assertions.assertThrows(NotFoundException.class, () -> postService.getPostsFromFollowedUsers(USER_ID, ORDER));
    }

    @Test
    @DisplayName("T-0008: Not found sellers")
    void getPostsFromFollowedUsersExceptionSellersNotFound() {
        // Arrange
        User testUser = User.builder()
                .id(USER_ID)
                .name("User")
                .follows(Arrays.asList())
                .build();
        when(userRepository.getById(USER_ID)).thenReturn(Optional.of(testUser));

        // Act && Assert NotFoundException
        Assertions.assertThrows(NoSellersFollowedException.class, () -> postService.getPostsFromFollowedUsers(USER_ID, ORDER));
    }

    private Seller createTestSeller() {
        return new Seller(1, "Juansito", new ArrayList<>());
    }

    private Product createTestProduct() {
        return Product.builder()
                .id(1)
                .name("Juego")
                .type("Gamer")
                .brand("Box")
                .color("Black")
                .notes("Notes this is a game for box")
                .build();
    }

    private Post createTestPost(Product product, Seller seller) {
        return Post.builder()
                .id(1)
                .date(LocalDate.now())
                .price(1000.0)
                .product(product)
                .seller(seller)
                .discount(0.1)
                .hasPromo(true)
                .category(100)
                .build();
    }

    private List<Seller> createSellers() {
        Seller seller1 = Seller.builder()
                .id(1)
                .name("Seller 1")
                .build();

        Seller seller2 = Seller.builder()
                .id(2)
                .name("Seller 2")
                .build();

        return Arrays.asList(seller1, seller2);
    }

    private List<Product> createProducts() {
        Product product1 = Product.builder()
                .id(1)
                .name("Juego")
                .type("Gamer")
                .brand("Box")
                .color("Black")
                .notes("Notes this is a game for box")
                .build();

        Product product2 = Product.builder()
                .id(2)
                .name("Mesa")
                .type("Gamer")
                .brand("Desk")
                .color("White")
                .notes("Notes this is a desk white")
                .build();

        return Arrays.asList(product1, product2);
    }

    private List<Post> createPosts() {
        Post post1 = new Post(11, CURRENT_DATE.minusWeeks(1), 1000.0,
                products.get(0), sellers.get(0), 0.1, true, 100);

        Post post2 = new Post(12, CURRENT_DATE.minusDays(13), 200.0,
                products.get(1), sellers.get(1), 0.0, false, 200);

        Post post3 = new Post(13, CURRENT_DATE.minusWeeks(3), 200.0,
                products.get(1), sellers.get(1), 0.0, false, 200);

        return Arrays.asList(post1, post2, post3);
    }

    private List<PostDto> createPostsDtosBeforeTwoWeeks(List<Post> postsToConvert){
        List<PostDto> postsDtos = postsToConvert.stream()
                                                .filter(post -> post.getDate().isAfter(LocalDate.now().minusWeeks(2)))
                                                .map(post -> PostDto.builder()
                                                .userId(post.getSeller().getId())
                                                .id(post.getId())
                                                .date(post.getDate())
                                                .product(ProductDto.builder()
                                                        .productId(post.getProduct().getId())
                                                        .productName(post.getProduct().getName())
                                                        .type(post.getProduct().getType())
                                                        .brand(post.getProduct().getBrand())
                                                        .color(post.getProduct().getColor())
                                                        .notes(post.getProduct().getNotes())
                                                        .build())
                                                .category(post.getCategory())
                                                .price(post.getPrice())
                                                .hasPromo(post.getHasPromo())
                                                .discount(post.getDiscount())
                                                .build())
                                                .toList();
             return postsDtos;            
    
    } 
     private PostOrder getPostOrder(Integer orderValue) {
        return Arrays.stream(PostOrder.values())
                .filter(order -> order.getValueFromOrder() == orderValue)
                .findFirst()
                .orElse(PostOrder.DESCENDING);
    }
    private User createTestUser() {
        return User.builder()
                .id(USER_ID)
                .name("User")
                .follows(sellers)
                .build();
    }
}