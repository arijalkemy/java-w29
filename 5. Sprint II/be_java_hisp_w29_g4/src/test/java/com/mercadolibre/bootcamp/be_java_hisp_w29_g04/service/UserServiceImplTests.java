package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowersCountDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowersDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowingDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.BadRequestException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.InvalidRelationshipException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception.NotFoundException;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.UserOrderTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.CommonUser;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.Seller;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.UserTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.repository.IUserRepository;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils.IUserValidation;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTests {

    @Mock
    private IUserRepository userRepository;

    @Mock
    private IUserValidation userValidation;

    @InjectMocks
    private UserServiceImpl userService;

    /* #--------------- T-0004 & US-0008 ---------------# */
    private User seller1;
    private User user1;
    private List<User> mockUsers;

    /* #--------------- T-0001 & T-0002 | US-0001 & US-0007 ---------------# */
    private User commonUser;
    private User seller;
    private final Integer USER_ID = 86;
    private final Integer SELLER_ID = 87;

    /* #--------------- T-0003 | US-0003 & US-0004 & US-0008 ---------------# */
    private static final List<String> orderList = List.of("name_asc","name_desc","unordered");

    private static List<String> getOrderList(){return orderList;}


    @BeforeEach
    void initializeTestUsers() {
        commonUser = new CommonUser("Juan");
        commonUser.setUserId(USER_ID);
        seller = new Seller("Adidas");
        seller.setUserId(SELLER_ID);
    }


    @BeforeEach
    void setup() {
        seller1 = new Seller("AStore");                   //id1
        User seller2 = new Seller("BStore");              //id2
        User seller3 = new Seller("CStore");              //id3
        user1 = new CommonUser("ABClient");               //id4
        User user2 = new CommonUser("BBClient");          //id5
        User user3 = new CommonUser("CAClient");          //id6
        User user4 = new CommonUser("CBClient");          //id7
        User user5 = new CommonUser("DBClient");          //id8
        mockUsers = new ArrayList<>(List.of(
                seller1,
                seller2,
                seller3,
                user1,
                user2,
                user3,
                user4,
                user5
        ));

        seller1.addFollow(user1.getUserId());
        seller1.addFollow(user2.getUserId());
        seller1.addFollow(user3.getUserId());
        seller1.addFollow(user4.getUserId());
        seller1.addFollow(user5.getUserId());

        user1.addFollow(seller1.getUserId());
        user1.addFollow(seller2.getUserId());
        user1.addFollow(seller3.getUserId());
    }

    /* #--------------- T-0001 & T-0002 | US-0001 & US-0007 ---------------# */

    @Test
    @DisplayName("T-0001: Verify existence of the user to follow")
    void followSeller_validUsers_followedSuccessfully_test(){
        when(userValidation.isCommonUser(commonUser)).thenReturn(true);
        when(userValidation.isSeller(seller)).thenReturn(true);
        boolean doesFollow = userService.checkFollow(commonUser, seller);

        when(userRepository.update(any())).thenReturn(Optional.of(commonUser)).thenReturn(Optional.of(seller));
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(commonUser));
        when(userRepository.findById(SELLER_ID)).thenReturn(Optional.of(seller));
        MessageDto result = userService.followSeller(USER_ID, SELLER_ID);

        assertNotNull(result);
        assertFalse(doesFollow);

        assertEquals("Followed seller successfully", result.getMessage());
    }

    @Test
    @DisplayName("T-0001.1: Follow seller with an invalid user FAIL")
    void followSeller_userIsNotCommon_throwsException() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(commonUser));
        when(userRepository.findById(SELLER_ID)).thenReturn(Optional.of(seller));
        when(userValidation.isCommonUser(commonUser)).thenReturn(false);

        InvalidRelationshipException exception = assertThrows(InvalidRelationshipException.class,
                () -> userService.followSeller(USER_ID, SELLER_ID));
        assertEquals("Invalid user id", exception.getMessage());
    }

    @Test
    @DisplayName("T-0001.2: Invalid seller to follow FAIL")
    void followSeller_userIsNotSeller_throwsException() {
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(commonUser));
        when(userRepository.findById(SELLER_ID)).thenReturn(Optional.of(seller));
        when(userValidation.isCommonUser(commonUser)).thenReturn(true);

        InvalidRelationshipException exception = assertThrows(InvalidRelationshipException.class,
                () -> userService.followSeller(USER_ID, SELLER_ID));
        assertEquals("Invalid seller id", exception.getMessage());

    }

    @Test
    @DisplayName("T-0001.3: Follow already exists FAIL")
    void followSeller_followAlreadyExists_throwsException() {
        commonUser.addFollow(SELLER_ID);
        seller.addFollow(USER_ID);
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(commonUser));
        when(userRepository.findById(SELLER_ID)).thenReturn(Optional.of(seller));
        when(userValidation.isCommonUser(commonUser)).thenReturn(true);
        when(userValidation.isSeller(seller)).thenReturn(true);

        BadRequestException exception = assertThrows(BadRequestException.class, () -> {
            userService.followSeller(USER_ID, SELLER_ID);
        });
        assertEquals("Follow already exists", exception.getMessage());
    }


    @Test
    @DisplayName("T-0002: Unfollow seller with a valid user OK")
    void followSeller_validUsers_unfollowedSuccessfully_test() {
        commonUser.addFollow(SELLER_ID);
        seller.addFollow(USER_ID);
        when(userRepository.findById(USER_ID)).thenReturn(Optional.of(commonUser));
        when(userRepository.findById(SELLER_ID)).thenReturn(Optional.of(seller));

        when(userValidation.isCommonUser(commonUser)).thenReturn(true);
        when(userValidation.isSeller(seller)).thenReturn(true);
        boolean doesFollow = userService.checkFollow(commonUser, seller);


        when(userRepository.update(any())).thenReturn(Optional.of(commonUser)).thenReturn(Optional.of(seller));
        MessageDto result = userService.unfollowSeller(USER_ID, SELLER_ID);

        verify(userRepository, atLeast(1)).findById(USER_ID);
        verify(userRepository, atLeast(1)).findById(SELLER_ID);
        assertTrue(doesFollow);
        assertEquals("Unfollowed seller successfully", result.getMessage());

    }

    /* #--------------- T-0004 & US-0008 ---------------# */

    @DisplayName("Followers - Ascending Name")
    @Test
    public void test_followers_nameAscType_ok() {
        // 1. Arrange
        mockRepositoryFindById();

        // 2. Act
        FollowersDto followersDto = userService.getUsersBySeller(seller1.getUserId(), String.valueOf(UserOrderTypeEnum.NAME_ASC));
        List<UserDto> followers = followersDto.getFollowers();

        // 3. Assert
        assertEquals(5, followers.size());

        // Verify descending order
        for (int i = 0; i < followers.size() - 1; i++) {
            assertTrue(followers.get(i).getUserName().compareTo(followers.get(i + 1).getUserName()) <= 0,
                    "Followers should be sorted in ascending order by name");  // Cambiar el mensaje también
        }
    }

    @DisplayName("Followers - Descending Name")
    @Test
    public void test_followers_nameDescType_ok() {
        // 1. Arrange
        mockRepositoryFindById();

        // 2. Act
        FollowersDto followersDto = userService.getUsersBySeller(seller1.getUserId(), String.valueOf(UserOrderTypeEnum.NAME_DESC));
        List<UserDto> followers = followersDto.getFollowers();

        // 3. Assert
        assertEquals(5, followers.size());

        // Verify descending order
        for (int i = 0; i < followers.size() - 1; i++) {
            assertTrue(followers.get(i).getUserName().compareTo(followers.get(i + 1).getUserName()) >= 0,
                    "Followers should be sorted in descending order by name");
        }
    }

    @DisplayName("Followers - Invalid id")
    @Test
    public void test_followers_invalid_userid() {
        // 1. Arrange
        mockRepositoryFindById();

        // 2. Act & 3. Assert
        Assertions.assertThrows(
                InvalidRelationshipException.class,
                () -> {
                    userService.getUsersBySeller(user1.getUserId(), String.valueOf(UserOrderTypeEnum.NAME_DESC));
                }
        );
    }

    @DisplayName("Followings - Ascending Name")
    @Test
    public void test_followings_nameAscType_ok() {
        // 1. Arrange
        mockRepositoryFindById();

        // 2. Act
        FollowingDto followingDto = userService.getSellersByUser(user1.getUserId(), String.valueOf(UserOrderTypeEnum.NAME_ASC));
        List<UserDto> following = followingDto.getFollowing();

        // 3. Assert
        assertEquals(3, following.size());

        // Verify ascending order
        for (int i = 0; i < following.size() - 1; i++) {
            assertTrue(following.get(i).getUserName().compareTo(following.get(i + 1).getUserName()) <= 0,
                    "Following should be sorted in ascending order by name");
        }
    }

    @DisplayName("Followings - Descending Name")
    @Test
    public void test_followings_nameDescType_ok() {
        // 1. Arrange
        mockRepositoryFindById();

        // 2. Act
        FollowingDto followingDto = userService.getSellersByUser(user1.getUserId(), String.valueOf(UserOrderTypeEnum.NAME_DESC));
        List<UserDto> following = followingDto.getFollowing();

        // 3. Assert
        assertEquals(3, following.size());

        // Verify ascending order
        for (int i = 0; i < following.size() - 1; i++) {
            assertTrue(following.get(i).getUserName().compareTo(following.get(i + 1).getUserName()) >= 0,
                    "Following should be sorted in descending order by name");
        }
    }

    @DisplayName("Followings - Invalid id")
    @Test
    public void test_followings_invalid_userid() {
        // 1. Arrange
        mockRepositoryFindById();

        // 2. Act & 3. Assert
        Assertions.assertThrows(
                InvalidRelationshipException.class,
                () -> {
                    userService.getSellersByUser(seller1.getUserId(), String.valueOf(UserOrderTypeEnum.NAME_DESC));
                }
        );
    }

    private void mockRepositoryFindById() {
        // FIXME: cause ´userRepository´ is static, we cant Mock findById inside ´setup´ method.
        //  Maybe theres better way of doing this than in all tests.
        for (User mockUser : mockUsers) {
            Mockito.lenient().when(userValidation.isSeller(mockUser)).thenReturn(mockUser.getType() == UserTypeEnum.SELLER);
            Mockito.lenient().when(userValidation.isCommonUser(mockUser)).thenReturn(mockUser.getType() == UserTypeEnum.COMMON);
            Mockito.lenient().when(userRepository.findById(mockUser.getUserId())).thenReturn(Optional.of(mockUser));
        }
    }

    /* #--------------- T-0003 | US-0003 & US-0004 & US-0008 ---------------# */

    /* T 0003  Happy Path--> US 0008 */
    @ParameterizedTest
    @MethodSource("getOrderList")
    void test_isOrderType_Valid(String order){
        // Arrange
        UserOrderTypeEnum expected = switch (order) {
            case "name_asc" -> UserOrderTypeEnum.NAME_ASC;
            case "name_desc" -> UserOrderTypeEnum.NAME_DESC;
            case "unordered" -> UserOrderTypeEnum.UNORDERED;
            default -> throw new IllegalArgumentException("Unexpected order: " + order);
        };

        // Act Assert
        assertEquals(expected,userService.isOrderTypeValid(order));

    }
    /* T 0003  Bad Path--> US 0008 */
    @Test
    void test_isOrderType_NoValid(){
        // Arrange
        String order = "test";
        BadRequestException exception = assertThrows(BadRequestException.class,
                () -> userService.isOrderTypeValid(order));
        Assertions.assertEquals("Invalid order type" , exception.getMessage(), "El mensaje de la excepción debería ser el esperado.");

    }
    /* #--------------- T-0007 | US-0002 ---------------# Nico */
    @Test
    @DisplayName("getFollowersCount happy path")
    void test_getFollowersCount_ok(){
        // Arrange
        Seller seller = new Seller("techStore");
        seller.setFollow(Arrays.asList(2, 3));
        when(userRepository.findById(1)).thenReturn(Optional.of(seller));
        when(userValidation.isSeller(seller)).thenReturn(true);
        when(userRepository.getListOfFollows(1, UserOrderTypeEnum.UNORDERED))
                .thenReturn(Optional.of(Arrays.asList(
                        new CommonUser("mario"),
                        new CommonUser("luis"))));
        // Act
        FollowersCountDto result = userService.getFollowersCount(1);
        // Assert
        assertNotNull(result);
        assertEquals(seller.getUserId(), result.getUserId());
        assertEquals("techStore", result.getUserName());
        assertEquals(2, result.getFollowersCount());
    }
    @Test
    @DisplayName("Seller validation")
    void test_getFollowersCount_sellerValidationNoOk() {
        //Arrange
        User nonSeller = new CommonUser("Mario");
        when(userRepository.findById(1)).thenReturn(Optional.of(nonSeller));
        when(userValidation.isSeller(nonSeller)).thenReturn(false);
        //Act y Assert
        InvalidRelationshipException thrown = assertThrows(InvalidRelationshipException.class, () -> {
            userService.getFollowersCount(1);
        });
        assertEquals("Only sellers have followers", thrown.getMessage());
    }
    @Test
    @DisplayName("Follower empty")
    void test_getFollowersCount_followerEmptyNoOk() {
        Seller seller = new Seller("techStore");
        seller.setFollow(Arrays.asList());
        when(userRepository.findById(1)).thenReturn(Optional.of(seller));
        when(userValidation.isSeller(seller)).thenReturn(true);
        when(userRepository.getListOfFollows(1, UserOrderTypeEnum.UNORDERED))
                .thenReturn(Optional.of(Arrays.asList()));
        // Act & Assert
        NotFoundException thrown = assertThrows(NotFoundException.class, () -> {
            userService.getFollowersCount(1);
        });
        assertEquals("No followers for the given user", thrown.getMessage());
    }

}