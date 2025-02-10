package com.socialmeli.socialmeli.services;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.ProductDto;
import com.socialmeli.socialmeli.dto.response.PostIdDto;
import com.socialmeli.socialmeli.dto.response.ProductListDto;
import com.socialmeli.socialmeli.dto.response.ProductSaleCountDto;
import com.socialmeli.socialmeli.exception.AlreadyExistsException;
import com.socialmeli.socialmeli.exception.NotFoundException;
import com.socialmeli.socialmeli.exception.UserNotSellerException;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.User;
import com.socialmeli.socialmeli.repositories.IFollowRepository;
import com.socialmeli.socialmeli.repositories.IPostRepository;
import com.socialmeli.socialmeli.repositories.IUserRepository;
import com.socialmeli.socialmeli.utils.PostFactory;
import com.socialmeli.socialmeli.utils.UserFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {

    @Mock
    private  IPostRepository postRepository;

    @Mock
    private  IUserRepository userRepository;

    @Mock
    private  IFollowRepository followRepository;

    @InjectMocks
    private PostService service;

    // US 0005 - Dar de alta una nueva publicación.
    // US 0010 - Llevar a cabo la publicación de un nuevo producto en promoción.
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("#73 savePost - should save the post when product does not exist and user is not seller")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void savePost_whenProductDoesNotExistAndUserIsNotSeller_thenSavePost(boolean hasPromo) {
        // Arrange
        Integer userId = 2;
        Integer productId = 300;

        User user = UserFactory.createBuyer(userId);
        Object post = PostFactory.createPostDto(userId, productId, hasPromo);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(postRepository.existsProductById(productId)).thenReturn(false);

        // Act
        if (hasPromo) {
            service.savePostSale((PostSaleDto) post);
        } else {
            service.savePost((PostDto) post);
        }

        // Assert
        verify(userRepository).update(user);
        verify(postRepository).save(any(Post.class));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("#74 savePost - should save the post when product does not exist and user is seller")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void savePost_whenProductDoesNotExistAndUserIsSeller_thenSavePost(boolean hasPromo) {
        // Arrange
        Integer userId = 1;
        Integer productId = 2;

        User user = UserFactory.createSeller(userId);
        Object post = PostFactory.createPostDto(userId, productId, hasPromo);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(postRepository.existsProductById(productId)).thenReturn(false);

        // Act
        if (hasPromo) {
            service.savePostSale((PostSaleDto) post);
        } else {
            service.savePost((PostDto) post);
        }

        // Assert
        verify(userRepository, never()).update(user);

        verify(postRepository).save(any(Post.class));
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("#75 savePost - should throw AlreadyExistsException when product already exists")
    void savePost_whenProductAlreadyExists_thenThrowAlreadyExistsException(boolean hasPromo) {
        // Arrange
        Integer userId = 1;
        Integer productId = 201;

        User user = UserFactory.createSeller(userId);
        Object post = PostFactory.createPostDto(userId, productId, hasPromo);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(postRepository.existsProductById(productId)).thenReturn(true);

        // Act & Assert
        assertThrows(AlreadyExistsException.class, () -> {
            if (hasPromo) {
                service.savePostSale((PostSaleDto) post);
            } else {
                service.savePost((PostDto) post);
            }
        });
    }

    // US 0006 - Obtener un listado de las publicaciones realizadas en las últimas dos semanas,
    // por los vendedores que un usuario sigue
    @Test
    @DisplayName("#76 getRecentPostFromUsersAscTest - should retrun a list of post ordered Asc")
    void getRecentPostFromUsersTest_whenFollowsPostedLast2WeeksAndOrderIsDateAsc_thenReturnListOfPostOrderedAsc() {
        // Arrange
        String order = "date_asc";
        User user = UserFactory.createBuyer(4);
        Integer id = user.getId();
        List<User> sellersFollowed = UserFactory.getListOfSellers();
        List<Post> postsFromFollows = PostFactory.getPostsForUsers(sellersFollowed);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(followRepository.findFollowedUsersById(id)).thenReturn(sellersFollowed);
        when(postRepository.postFromUsers(sellersFollowed)).thenReturn(postsFromFollows);
        List<PostIdDto> expectedPosts = new ArrayList<>();
        expectedPosts.add(PostIdDto.builder()
                .id(3)
                .userId(2)
                .date(LocalDate.now().minusDays(2))
                .product(new ProductDto())
                .category(1)
                .price(100.0)
                .build());

        expectedPosts.add(PostIdDto.builder()
                .id(1)
                .userId(1)
                .date(LocalDate.now().minusDays(1))
                .product(new ProductDto())
                .category(1)
                .price(100.0)
                .build());


        ProductListDto expected = new ProductListDto(id, expectedPosts);

        // Act
        ProductListDto actual = service.getRecentPostFromUsers(order, id);
        // Assert
        assertEquals(expected, actual);
        assertEquals(expected.getPosts(), actual.getPosts());
        verify(userRepository).findById(id);
        verify(followRepository).findFollowedUsersById(id);
        verify(postRepository).postFromUsers(sellersFollowed);
    }

    @Test
    @DisplayName("#77 getRecentPostFromUsersDescTest - should retrun a list of post ordered Desc")
    void getRecentPostFromUsersTest_whenFollowedPostedLast2WeeksAndOrderIsDateDesc_thenReturnListOfPostOrderedDesc() {
        // Arrange
        String order = "date_desc";
        User user = UserFactory.createBuyer(4);
        Integer id = user.getId();
        List<User> sellersFollowed = UserFactory.getListOfSellers();
        List<Post> postsFromFollows = PostFactory.getPostsForUsers(sellersFollowed);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        when(followRepository.findFollowedUsersById(id)).thenReturn(sellersFollowed);
        when(postRepository.postFromUsers(sellersFollowed)).thenReturn(postsFromFollows);
        List<PostIdDto> expectedPosts = new ArrayList<>();
        expectedPosts.add(PostIdDto.builder()
                .id(1)
                .userId(1)
                .date(LocalDate.now().minusDays(1))
                .product(new ProductDto())
                .category(1)
                .price(100.0)
                .build());

        expectedPosts.add(PostIdDto.builder()
                .id(3)
                .userId(2)
                .date(LocalDate.now().minusDays(2))
                .product(new ProductDto())
                .category(1)
                .price(100.0)
                .build());

        ProductListDto expected = new ProductListDto(id, expectedPosts);

        // Act
        ProductListDto actual = service.getRecentPostFromUsers(order, id);
        // Assert
        assertEquals(expected, actual);
        assertEquals(expected.getPosts(), actual.getPosts());
        verify(userRepository).findById(id);
        verify(followRepository).findFollowedUsersById(id);
        verify(postRepository).postFromUsers(sellersFollowed);
    }

    @Test
    @DisplayName("#78 getRecentPostFromUsersNotFoundTest - should throw NotFoundException")
    void getRecentPostFromUsersTest_whenUserNotFound_thenThrowUserNotFoundException() {
        // Arrange
        Integer userId = 800;
        String order = "date_asc";

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(NotFoundException.class, () -> {
            service.getRecentPostFromUsers(order, userId);
        });
    }

    //US-0011 - Obtener la cantidad de productos en promoción de un determinado vendedor
    @Test
    @DisplayName("#84 countProductSaleByUser - successful")
    public void getProductSaleCountByUser_whenUserExists_thenGetProductSaleCountByUser() {
        //Arrange
        User user = UserFactory.createSeller(3, "Ciro Sánchez");
        ProductSaleCountDto expected = new ProductSaleCountDto(user.getId(), user.getName(), 3);
        List<Post> posts = PostFactory.createListPostSale(user);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(postRepository.findPostsWithPromoByUser(user.getId())).thenReturn(posts);

        //Act
        ProductSaleCountDto result = service.getProductSaleCountByUser(user.getId());

        //Assertions
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("#85 countProductSaleByUser - user not found")
    public void getProductSaleCountByUser_whenUserNotFound_thenThrowUserNotFoundException() {
        //Arrange
        Integer id = 90;

        when(userRepository.findById(id)).thenReturn(Optional.empty());

        //Act & Assertions
        assertThrows(NotFoundException.class, () -> service.getProductSaleCountByUser(id));
    }

    @Test
    @DisplayName("#86 countProductSaleByUser - user is not seller")
    public void getProductSaleCountByUser_whenUserIsNotSeller_thenThrowUserNotSellerException() {
        //Arrange
        User user = UserFactory.createBuyer(2, "Carolina Comba");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        //Act & Assertions
        assertThrows(UserNotSellerException.class, () -> service.getProductSaleCountByUser(user.getId()));
    }

    @Test
    @DisplayName("#87 countProductSaleByUser - empty list")
    public void getProductSaleCountByUser_whenWithoutPromoPost_thenThrowUserNotFoundException() {
        //Arrange
        User user = UserFactory.createSeller(3, "Ciro Sánchez");

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        when(postRepository.findPostsWithPromoByUser(user.getId())).thenReturn(List.of());

        //Act & Assertions
        assertThrows(UserNotSellerException.class, () -> service.getProductSaleCountByUser(user.getId()));
    }
}
