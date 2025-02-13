package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.ProductDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PostsBySellersFollowedDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.BadRequestException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.InvalidOrderException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.NotFoundException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Post;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.PostOrderTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.Product;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.CommonUser;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.Seller;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository.IPostRepository;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils.IUserValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTests {
    @Mock
    private IPostRepository postRepository;
    @Mock
    private IUserService userService;
    @Mock
    private IUserValidation userValidation;
    @InjectMocks
    private PostServiceImpl postService;

    /* #--------------- T-0005 & T-0006 | US-0009 ---------------# */
    private final Integer USER_ID = 89;
    private final Integer SELLER_ID = 90;
    private PostOrderTypeEnum order = PostOrderTypeEnum.UNORDERED;

    /* #--------------- T-0005 & T-0006 | US-0009 ---------------# */

    /* #--------------- T-0008 | US-0006 ---------------# */
    private CommonUser commonUser;
    private Seller sellerUser;
    private Post todayPost;
    private Post twoWeeksPost;
    private Post moreTwoWeekPost;
    /* #--------------- T-0008 | US-0006 ---------------# */

    @BeforeEach
    void setUp(){
        //Data T-0008
        sellerUser = new Seller("sellerUser", new ArrayList<>());
        commonUser = new CommonUser( "commonUser", List.of(sellerUser.getUserId()));

        Product product = new Product(1, "Macbook", "Computadora", "Apple", "Plateado", "");
        todayPost = new Post(sellerUser.getUserId(), product, LocalDate.now(),10,100.0); //Post de hoy
        twoWeeksPost = new Post(sellerUser.getUserId(), product,LocalDate.now().minusWeeks(1),10,100.0); //Post de hace 1 semanas
        moreTwoWeekPost = new Post(sellerUser.getUserId(), product,LocalDate.now().minusWeeks(3),10,100.0); // Post de hace 3 semanas
    }

    /* #--------------- T-0005 & T-0006 | US-0009 ---------------# */

    @Test
    @DisplayName("T-0005 - Invalid order throws exception")
    void getPostsOfFollowedSeller_InvalidOrderException () {
        // Arrange
        String badOrder = "badOrder";
        // Act && Assert
        assertThrows(InvalidOrderException.class, () -> postService.getPostOrderType(badOrder));
    }

    @Test
    @DisplayName("getPostsOfFollowedSeller - Invalid user throws exception")
    void getPostsOfFollowedSeller_BadRequestException () {
        // Arrange
        User seller = new Seller("seller1");
        when(userService.findById(SELLER_ID)).thenReturn(seller);
        when(userValidation.isCommonUser(seller)).thenReturn(false);
        // Act && Assert
        assertThrows(BadRequestException.class, () -> postService.getPostsOfFollowedSeller(SELLER_ID, order));
    }

    @Test
    @DisplayName("getPostsOfFollowedSeller - Empty following throws exception")
    void getPostsOfFollowedSeller_NotFoundException () {
        // Arrange
        User common = new CommonUser("common1");
        when(userService.findById(USER_ID)).thenReturn(common);
        when(userValidation.isCommonUser(common)).thenReturn(true);
        // Act && Assert
        assertThrows(NotFoundException.class, () -> postService.getPostsOfFollowedSeller(USER_ID, order));
    }

    /* #--------------- T-0008 | US-0006 ---------------# */

    /* T 0008 Happy Path--> US 0006 */
    @Test
    @DisplayName("Post from the last two weeks from the sellers I follow")
    void twoWeekPostBySellersFollowTest() {
        when(userService.findById(commonUser.getUserId())).thenReturn(commonUser);
        when(postRepository.getUserPosts(sellerUser.getUserId())).thenReturn(List.of(todayPost, twoWeeksPost));
        when(userValidation.isCommonUser(commonUser)).thenReturn(true);

        PostsBySellersFollowedDto result = postService.getPostsOfFollowedSeller(commonUser.getUserId(), PostOrderTypeEnum.DATE_DESC);

        assertNotNull(result);
        assertEquals(2, result.getPosts().size());
        assertEquals(LocalDate.now(), result.getPosts().get(0).getCreatedAt()); // El post 0 debe ser todayPost
        assertEquals(LocalDate.now().minusWeeks(1), result.getPosts().get(1).getCreatedAt()); // El post 1 debe ser twoWeeksPost
    }

    /* T 0008 Throw NotFoundException because the user does not exist--> US 0006 */
    @Test
    @DisplayName("Post from a user that does not exist")
    void twoWeekPostBySellersFollow_UserNotFoundTest(){
        when(userService.findById(commonUser.getUserId())).thenThrow(new NotFoundException("User not found"));

        assertThrows(NotFoundException.class, () -> postService.getPostsOfFollowedSeller(commonUser.getUserId(), PostOrderTypeEnum.DATE_DESC));
    }
    /* T 0008 Throw BadRequestException--> US 0006 */
    @Test
    @DisplayName("Post from a user that is Seller user")
    void twoWeekPostBySellersFollow_NotACommonUser() {
        when(userService.findById(sellerUser.getUserId())).thenReturn(sellerUser);

        assertThrows(BadRequestException.class, () -> postService.getPostsOfFollowedSeller(sellerUser.getUserId(), PostOrderTypeEnum.DATE_DESC));
    }

    /* T 0008 Throw NotFoundException because the user does not follow sellers--> US 0006 */
    @Test
    @DisplayName("Post from a user that not followed sellers")
    void twoWeekPostBySellersFollow_NoFollowedSellers() {
        CommonUser userWithoutFollows = new CommonUser( "UserWhitoutFollow", new ArrayList<>());
        when(userValidation.isCommonUser(userWithoutFollows)).thenReturn(true);
        when(userService.findById(userWithoutFollows.getUserId())).thenReturn(userWithoutFollows);

        assertThrows(NotFoundException.class, () -> postService.getPostsOfFollowedSeller(userWithoutFollows.getUserId(), PostOrderTypeEnum.DATE_DESC));
    }

    /* T 0008 No post less than two weeks old--> US 0006 */
    @Test
    @DisplayName("Post from a seller with a post of more than two weeks")
    void twoWeekPostBySellersFollow_MoreTwoWeeksPosts() {
        when(userService.findById(commonUser.getUserId())).thenReturn(commonUser);
        when(postRepository.getUserPosts(sellerUser.getUserId())).thenReturn(List.of(moreTwoWeekPost));
        when(userValidation.isCommonUser(commonUser)).thenReturn(true);

        PostsBySellersFollowedDto result = postService.getPostsOfFollowedSeller(commonUser.getUserId(), PostOrderTypeEnum.DATE_DESC);

        assertNotNull(result);
        assertTrue(result.getPosts().isEmpty());
    }

    @Nested
    @DisplayName("order-DATE-OK")
    class OrderDate {
        Post post1;
        Post post2;
        Post post3;
        PostDto postDto1;
        PostDto postDto2;
        PostDto postDto3;
        LocalDate currentDate;
        Integer sellerId2;
        Integer sellerId3;

        @BeforeEach
        void initializeCommonData(){

            //Data T-0005 & T-0006
            sellerId2 = 2;
            sellerId3 = 3;
            currentDate = LocalDate.now();
            post1 = new Post(2, new Product(), currentDate, 1, 1500.00);
            post2 = new Post(3, new Product(), currentDate.minusDays(2), 1, 1000.00);
            post3 = new Post(4, new Product(), currentDate.minusDays(4), 1, 500.00);
            postDto1 = new PostDto(2, currentDate, new ProductDto(), 1, 1500.00);
            postDto2 = new PostDto(3, currentDate.minusDays(2), new ProductDto(), 1, 1000.00);
            postDto3 = new PostDto(4, currentDate.minusDays(4), new ProductDto(), 1, 500.00);

        }

        @Test
        @DisplayName("T-0006 - Date Order ASC")
        void getPostsOfFollowedSeller_OrderAsc () {
            // Arrange
            order = PostOrderTypeEnum.DATE_ASC;
            User common = new CommonUser("common1", List.of(SELLER_ID, sellerId2, sellerId3));
            PostsBySellersFollowedDto expected = new PostsBySellersFollowedDto(USER_ID, List.of(postDto3, postDto2, postDto1));
            when(userService.findById(USER_ID)).thenReturn(common);
            when(userValidation.isCommonUser(common)).thenReturn(true);
            when(postRepository.getUserPosts(SELLER_ID)).thenReturn(List.of(post1));
            when(postRepository.getUserPosts(sellerId2)).thenReturn(List.of(post2));
            when(postRepository.getUserPosts(sellerId3)).thenReturn(List.of(post3));
            when(userValidation.isCommonUser(common)).thenReturn(true);
            // Act
            PostsBySellersFollowedDto actual = postService.getPostsOfFollowedSeller(USER_ID, order);
            // Assert
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("T-0006 - Date Order DESC")
        void getPostsOfFollowedSeller_OrderDesc () {
            // Arrange
            order = PostOrderTypeEnum.DATE_DESC;
            User common = new CommonUser("common1", List.of(SELLER_ID, sellerId2, sellerId3));
            PostsBySellersFollowedDto expected = new PostsBySellersFollowedDto(USER_ID, List.of(postDto1, postDto2, postDto3));
            when(userService.findById(USER_ID)).thenReturn(common);
            when(userValidation.isCommonUser(common)).thenReturn(true);
            when(postRepository.getUserPosts(SELLER_ID)).thenReturn(List.of(post1));
            when(postRepository.getUserPosts(sellerId2)).thenReturn(List.of(post2));
            when(postRepository.getUserPosts(sellerId3)).thenReturn(List.of(post3));
            // Act
            PostsBySellersFollowedDto actual = postService.getPostsOfFollowedSeller(USER_ID, order);
            // Assert
            assertEquals(expected, actual);
        }
    }
}
