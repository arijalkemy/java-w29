package sprint1.be_java_hisp_w29_g9.services;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.SellerFollowersCountResponseDTO;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.SellerFollowersInfoDTO;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.UserFollowedResponseDTO;
import sprint1.be_java_hisp_w29_g9.dtos.users.response.UserFollowersDTO;
import sprint1.be_java_hisp_w29_g9.entities.Seller;
import sprint1.be_java_hisp_w29_g9.entities.User;
import sprint1.be_java_hisp_w29_g9.exceptions.BadRequestException;
import sprint1.be_java_hisp_w29_g9.exceptions.NotFoundException;
import sprint1.be_java_hisp_w29_g9.repositories.UserSellerRepoImp;
import sprint1.be_java_hisp_w29_g9.utils.TestUtilsGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

    @Mock
    UserSellerRepoImp userSellerRepoImp;

    @Mock
    MessageSource messageSourceBean;

    @InjectMocks
    UserServiceImp userServiceImp;

    @Test
    public void unfollowUserTestOk(){

        //Arrange
        Integer userIdParam = 1;
        Integer sellerIdParam = 1;
        Optional<User> userResponse =  Optional.of(new User(1,"John Doe"));
        Optional<Seller> sellerResponse = Optional.of(TestUtilsGenerator.getSellerWithPosts("John Seller"));

        Mockito.when(userSellerRepoImp.getUserById(userIdParam)).thenReturn(userResponse);
        Mockito.when(userSellerRepoImp.getSellerById(sellerIdParam)).thenReturn(sellerResponse);
        Mockito.when(userSellerRepoImp.removeSellerFollower(userIdParam,sellerIdParam)).thenReturn(true);
        //Act
        boolean actualResponse = userServiceImp.unfollowUser(userIdParam,sellerIdParam);
        //Assert
        Assertions.assertTrue(actualResponse);

    }

    @Test
    public void unfollowUserTestNoOkUser(){
        //Arrange
        Integer userIdParam = 999;
        Integer sellerIdParam = 1;
        Optional<User> userResponse = Optional.empty();
        Optional<Seller> sellerResponse = Optional.of(TestUtilsGenerator.getSellerWithPosts("John Seller"));
        Mockito.when(userSellerRepoImp.getUserById(userIdParam)).thenReturn(userResponse);
        Mockito.when(userSellerRepoImp.getSellerById(sellerIdParam)).thenReturn(sellerResponse);
        //Act and Assert
        Assertions.assertThrows(NotFoundException.class,()-> userServiceImp.unfollowUser(userIdParam,sellerIdParam));
    }

    @Test
    public void unfollowUserTestNoOkSeller(){
        //Arrange
        Integer userIdParam = 1;
        Integer sellerIdParam = 999;
        Optional<User> userResponse = Optional.of(new User(1,"John Doe"));
        Optional<Seller> sellerResponse = Optional.empty();
        Mockito.when(userSellerRepoImp.getUserById(userIdParam)).thenReturn(userResponse);
        Mockito.when(userSellerRepoImp.getSellerById(sellerIdParam)).thenReturn(sellerResponse);
        //Act and Assert
        Assertions.assertThrows(NotFoundException.class,()-> userServiceImp.unfollowUser(userIdParam,sellerIdParam));
    }

    @Test
    public void correctTypeOfOrderTest(){
        Integer sellerId = 1;
        String typeOrder = "name_asc";
        Optional<Seller> seller = Optional.of(new Seller());
        List<User> followers = List.of(new User());

        Mockito.when(userSellerRepoImp.getSellerById(sellerId)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getSellerFollowersById(sellerId)).thenReturn(followers);

        UserFollowersDTO result = userServiceImp.getFollowersList(sellerId, typeOrder);

        Assertions.assertNotNull(result);

    }

    @Test
    public void incorrectTypeOfOrderTest(){
        Integer sellerId = 1;
        Optional<Seller> seller = Optional.of(new Seller());
        List<User> followers = List.of(new User());
        String typeOrder = "invalid_order";
        String message = "El tipo de ordenamiento es incorrecto.";

        Mockito.when(userSellerRepoImp.getSellerById(sellerId)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getSellerFollowersById(sellerId)).thenReturn(followers);
        Mockito.when(messageSourceBean.getMessage("type_of_order_not_exist", null, null)).thenReturn(message);

        BadRequestException exception = Assertions.assertThrows(BadRequestException.class,
                ()->{userServiceImp.getFollowersList(sellerId, typeOrder);});

        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    public void typeOfOrderNullTest(){
        Integer sellerId = 1;
        Optional<Seller> seller = Optional.of(new Seller());
        List<User> followers = List.of(new User());
        String typeOrder = null;

        Mockito.when(userSellerRepoImp.getSellerById(sellerId)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getSellerFollowersById(sellerId)).thenReturn(followers);

        UserFollowersDTO result = userServiceImp.getFollowersList(sellerId, typeOrder);

        Assertions.assertNotNull(result);
    }

    //T-0004_1 (getFollowersList)
    @Test void verifyCorrectAscendingSellerOrderTest(){
        //Arrange
        Optional<Seller> seller = Optional.of(new Seller(1,  List.of(),"SellerTemp"));
        List<User> followers = List.of(
                new User(1, "Edward"),
                new User(2, "Jhon"),
                new User(3, "David"),
                new User(4,"Zamira")
        );
        Mockito.when(userSellerRepoImp.getSellerById(1)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getSellerFollowersById(1)).thenReturn(followers);
        //Act
        UserFollowersDTO result = userServiceImp.getFollowersList(1, "name_asc");
        //Assert
        List<String> expectedOrder = List.of("David","Edward","Jhon", "Zamira");
        List<String> actualOrder = result.getFollowers().stream()
                .map(User::getFullname)
                .toList();
        Assertions.assertEquals(expectedOrder,actualOrder);
    }

    //T-0004_1 (userFollowed)
    @Test
    void verifyCorrectAscendingUserOrderTest() {
        // Arrange
        Optional<User> user = Optional.of(new User(1, "UserTemp"));
        List<Seller> followedSellers = List.of(
                new Seller(1, List.of(), "Carlos"),
                new Seller(2, List.of(), "Ana"),
                new Seller(3, List.of(), "Bruno"),
                new Seller(4, List.of(), "Daniel")
        );

        Mockito.when(userSellerRepoImp.getUserById(1)).thenReturn(user);
        Mockito.when(userSellerRepoImp.getUserFollowedById(1)).thenReturn(followedSellers);

        // Act
        UserFollowedResponseDTO result = userServiceImp.userFollowed(1, "name_asc");

        // Assert
        List<String> expectedOrder = List.of("Ana", "Bruno", "Carlos", "Daniel");
        List<String> actualOrder = result.getFollowed().stream()
                .map(SellerFollowersInfoDTO::getUser_name)
                .toList();

        Assertions.assertEquals(expectedOrder, actualOrder);
    }

    //T-0004_2 (getFollowersList)
    @Test void verifyCorrectDescendingOrderTest(){
        //Arrange
        Optional<Seller> seller = Optional.of(new Seller(1,  List.of(),"SellerTemp"));
        List<User> followers = List.of(
                new User(1, "Juan"),
                new User(2, "David"),
                new User(3, "Santiago"),
                new User(4,"Andrea")
        );
        Mockito.when(userSellerRepoImp.getSellerById(1)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getSellerFollowersById(1)).thenReturn(followers);
        //Act
        UserFollowersDTO result = userServiceImp.getFollowersList(1, "name_desc");
        //Assert
        List<String> expectedOrder = List.of("Santiago","Juan","David","Andrea");
        List<String> actualOrder = result.getFollowers().stream()
                .map(User::getFullname)
                .toList();
        Assertions.assertEquals(expectedOrder,actualOrder);
    }
    
    //T-0004_2 (userFollowed)
    @Test
    void verifyCorrectDescendingUserOrderTest() {
        // Arrange
        Optional<User> user = Optional.of(new User(1, "UserTemp"));
        List<Seller> followedSellers = List.of(
                new Seller(1, List.of(), "Jaime"),
                new Seller(2, List.of(), "Andrew"),
                new Seller(3, List.of(), "Luisa"),
                new Seller(4, List.of(), "Sarah")
        );

        Mockito.when(userSellerRepoImp.getUserById(1)).thenReturn(user);
        Mockito.when(userSellerRepoImp.getUserFollowedById(1)).thenReturn(followedSellers);

        // Act
        UserFollowedResponseDTO result = userServiceImp.userFollowed(1, "name_desc");

        // Assert
        List<String> expectedOrder = List.of("Sarah", "Luisa", "Jaime", "Andrew");
        List<String> actualOrder = result.getFollowed().stream()
                .map(SellerFollowersInfoDTO::getUser_name)
                .toList();

        Assertions.assertEquals(expectedOrder, actualOrder);
    }

    //T-0004_2 (userFollowed -> User Empty)
    @Test
    void verifyUserNotFoundThrowsException() {
        // Arrange
        Mockito.when(userSellerRepoImp.getUserById(1)).thenReturn(Optional.empty());
        Mockito.when(messageSourceBean.getMessage(eq("user_not_found"), any(), any()))
                .thenReturn("EL Usuario no fue encontrado.");

        // Act
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            userServiceImp.userFollowed(1, "name_asc");
        });
        // Assert
        Assertions.assertEquals("EL Usuario no fue encontrado.", thrown.getMessage());
    }

    //T-0004_2 (userFollowed -> sellers Empty)
    @Test
    void verifyNoFollowedUsersThrowsException() {
        // Arrange
        Optional<User> user = Optional.of(new User(1, "UserTemp"));

        Mockito.when(userSellerRepoImp.getUserById(1)).thenReturn(user);
        Mockito.when(userSellerRepoImp.getUserFollowedById(1)).thenReturn(List.of());
        Mockito.when(messageSourceBean.getMessage(eq("not_followed"), any(), any()))
                .thenReturn("El Usuario no sigue a ningun Vendedor.");

        // Act
        NotFoundException thrown = Assertions.assertThrows(NotFoundException.class, () -> {
            userServiceImp.userFollowed(1, "name_asc");
        });
        // Assert
        Assertions.assertEquals("El Usuario no sigue a ningun Vendedor.", thrown.getMessage());
    }

    @Test
    void followUserSuccessfully() {
        // Arrange

        User user = new User(1, "UserTest");
        Seller seller = new Seller(2, List.of(), "SellerTest");

        Mockito.when(userSellerRepoImp.getUserById(1)).thenReturn(Optional.of(user));
        Mockito.when(userSellerRepoImp.getSellerById(2)).thenReturn(Optional.of(seller));
        Mockito.when(userSellerRepoImp.getSellerFollowersById(2)).thenReturn(List.of());

        // Act
        userServiceImp.followUser(1, 2);

        // Assert
        Mockito.verify(userSellerRepoImp, Mockito.times(1)).addSellerToUser(user, seller);
    }

    @Test
    void followUserThrowsExceptionWhenAlreadyFollowed() {
        // Arrange
        User user = new User(1, "UserTest");
        Seller seller = new Seller(2, List.of(), "SellerTest");

        Mockito.when(userSellerRepoImp.getUserById(1)).thenReturn(Optional.of(user));
        Mockito.when(userSellerRepoImp.getSellerById(2)).thenReturn(Optional.of(seller));
        Mockito.when(userSellerRepoImp.getSellerFollowersById(2)).thenReturn(List.of(user)); // Ya lo sigue

        Mockito.when(messageSourceBean.getMessage(Mockito.eq("already_followed"), Mockito.any(), Mockito.any()))
                .thenReturn("Tu ya sigues al Vendedor.");

        // Act
        BadRequestException thrown = Assertions.assertThrows(BadRequestException.class, () -> {
            userServiceImp.followUser(1, 2);
        });

        // Assert
        Assertions.assertEquals("Tu ya sigues al Vendedor.", thrown.getMessage());
    }

    @Test
    public void followUserThrowsExceptionWhenEmptyUser() {
        Optional<Seller> seller = Optional.of(new Seller());
        Optional<User> user = Optional.empty();
        String message = "EL Usuario no fue encontrado.";

        Mockito.when(userSellerRepoImp.getSellerById(2)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getUserById(1)).thenReturn(user);
        Mockito.when(messageSourceBean.getMessage("user_not_found", null, null)).thenReturn(message);

        BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> {
            userServiceImp.followUser(1, 2);
        });

        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    public void followUserThrowsExceptionWhenSellerUser() {
        Optional<Seller> seller = Optional.empty();
        Optional<User> user = Optional.of(new User());
        String message = "El Vendedor no fue encontrado.";

        Mockito.when(userSellerRepoImp.getSellerById(2)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getUserById(1)).thenReturn(user);
        Mockito.when(messageSourceBean.getMessage("seller_not_found", null, null)).thenReturn(message);

        BadRequestException exception = Assertions.assertThrows(BadRequestException.class, () -> {
            userServiceImp.followUser(1, 2);
        });

        // Assert
        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    public void getFollowersListSellerEmpty(){
        Integer sellerId = 1;
        String order = "name_asc";
        Optional<Seller> seller = Optional.empty();
        String message = "El Vendedor no fue encontrado.";

        Mockito.when(userSellerRepoImp.getSellerById(sellerId)).thenReturn(seller);
        Mockito.when(messageSourceBean.getMessage("seller_not_found", null, null)).thenReturn(message);

        NotFoundException exception = Assertions.assertThrows(NotFoundException.class,
                ()->{userServiceImp.getFollowersList(sellerId, order);});

        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    public void getFollowersListFollowerEmpty(){
        Integer sellerId = 1;
        String order = "name_asc";
        Optional<Seller> seller = Optional.of(new Seller());
        List<User> followers  = Collections.emptyList();
        String message = "El Vendedor no tiene seguidores.";

        Mockito.when(userSellerRepoImp.getSellerById(sellerId)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getSellerFollowersById(sellerId)).thenReturn(followers);
        Mockito.when(messageSourceBean.getMessage("not_followers", null, null)).thenReturn(message);

        NotFoundException exception = Assertions.assertThrows(NotFoundException.class,
                ()->{userServiceImp.getFollowersList(sellerId, order);});

        Assertions.assertEquals(message, exception.getMessage());
    }

    @Test
    public void numberOfFollowersForSellerCorrectTest(){
        Integer sellerId = 1;
        Optional<Seller> seller = Optional.of(new Seller());
        List<User> users = List.of(new User(), new User(), new User());

        Mockito.when(userSellerRepoImp.getSellerById(sellerId)).thenReturn(seller);
        Mockito.when(userSellerRepoImp.getSellerFollowersById(sellerId)).thenReturn(users);

        SellerFollowersCountResponseDTO result = userServiceImp.numberOfFollowersForSeller(sellerId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.getFollowers_count());
    }

    @Test
    public void numberOfFollowersForSellerIncorrectTest(){
        Integer sellerId = 1;
        Optional<Seller> seller = Optional.empty();
        String message = "El Vendedor no fue encontrado.";

        Mockito.when(userSellerRepoImp.getSellerById(sellerId)).thenReturn(seller);
        Mockito.when(messageSourceBean.getMessage("seller_not_found", null, null)).thenReturn(message);

        NotFoundException exception = Assertions.assertThrows(NotFoundException.class, () -> {
            userServiceImp.numberOfFollowersForSeller(sellerId);
        });

        Assertions.assertNotNull(exception);
        Assertions.assertEquals(message, exception.getMessage());
    }
}
