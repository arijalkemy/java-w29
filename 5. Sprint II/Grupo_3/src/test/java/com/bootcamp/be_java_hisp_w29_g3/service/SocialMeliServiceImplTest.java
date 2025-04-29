package com.bootcamp.be_java_hisp_w29_g3.service;

import com.bootcamp.be_java_hisp_w29_g3.dto.request.BuyerFollowedSellersDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.response.*;
import com.bootcamp.be_java_hisp_w29_g3.entity.Buyer;
import com.bootcamp.be_java_hisp_w29_g3.entity.Post;
import com.bootcamp.be_java_hisp_w29_g3.entity.Product;
import com.bootcamp.be_java_hisp_w29_g3.entity.Seller;
import com.bootcamp.be_java_hisp_w29_g3.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w29_g3.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w29_g3.repository.IUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SocialMeliServiceImplTest {
    @Mock
    IUserRepository userRepository;

    @InjectMocks
    SocialMeliServiceImpl socialMeliService;

    @Test
    @DisplayName("US-0001 - Happy Path (T-0001)")
    void followSellerOkTest(){
        //Arrange
        Integer userId = 2;
        Integer userIdToFollow = 1;
        FollowDto expected = new FollowDto("Vendedor seguido correctamente");
        when(userRepository.existsBuyerById(userId)).thenReturn(true);
        when(userRepository.existsSellerById(userIdToFollow)).thenReturn(true);
        when(userRepository.buyerAlreadyFollowsSeller(userId,userIdToFollow)).thenReturn(false);

        //Act
        FollowDto actual = socialMeliService.followSeller(userId,userIdToFollow);

        //Assert
        verify(userRepository).followSeller(userId,userIdToFollow);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("US-0001 - NotFound Exception when Seller not exist (T-0001)")
    void followSellerThrowNotFoundExceptionWhenSellerDoesNotExist(){
        //Arrange
        Integer userId = 2;
        Integer userIdToFollow = 10;
        when(userRepository.existsSellerById(anyInt())).thenReturn(false);

        //Assert + Act
        assertThrows(NotFoundException.class,()-> socialMeliService.followSeller(userId,userIdToFollow));
    }

    @Test
    @DisplayName("US-0001 - NotFound Exception when Buyer not exist (T-0001)")
    void followSellerThrowNotFoundExceptionWhenBuyerDoesNotExist(){
        //Arrange
        Integer userId = 2;
        Integer userIdToFollow = 1;
        when(userRepository.existsSellerById(userIdToFollow)).thenReturn(true); //Necesito que pase este, asi va a la siguiente linea
        when(userRepository.existsBuyerById(userId)).thenReturn(false);

        //Assert + Act
        assertThrows(NotFoundException.class,()-> socialMeliService.followSeller(userId,userIdToFollow));
    }

    @Test
    @DisplayName("US-0001 - NotFound Exception when Buyer already follow Seller (T-0001)")
    void followSellerThrowBadRequestExceptionWhenBuyerAlreadyFollowsSeller(){
        //Arrange
        Integer userId = 2;
        Integer userIdToFollow = 1;
        when(userRepository.existsSellerById(anyInt())).thenReturn(true); //Necesito que pase este, asi va a la siguiente linea
        when(userRepository.existsBuyerById(anyInt())).thenReturn(true);
        when(userRepository.buyerAlreadyFollowsSeller(anyInt(),anyInt())).thenReturn(true);

        //Assert + Act
        assertThrows(BadRequestException.class,()-> socialMeliService.followSeller(userId,userIdToFollow));
    }

    @Test
    @DisplayName("US-0007 - Happy Path (T-0002)")
    void unfollowSellerOkTest(){
        //Arrange
        Integer userId = 2;
        Integer userIdToUnFollow = 1;
        UnfollowDto expected = new  UnfollowDto("El usuario ya no sigue al vendedor");
        when(userRepository.existsBuyerById(userId)).thenReturn(true);
        when(userRepository.existsSellerById(userIdToUnFollow)).thenReturn(true);
        when(userRepository.buyerAlreadyFollowsSeller(userId,userIdToUnFollow)).thenReturn(true);

        //Act
        UnfollowDto actual = socialMeliService.unfollowSeller(userId,userIdToUnFollow);

        //Assert
        verify(userRepository).unfollowSeller(userId,userIdToUnFollow);
        assertEquals(expected,actual);
    }

    @Test
    @DisplayName("US-0007 - NotFound Exception when Seller not exist (T-0002)")
    void unfollowSellerThrowNotFoundExceptionWhenSellerDoesNotExist(){
        //Arrange
        Integer userId = 2;
        Integer userIdToUnFollow = 10;
        when(userRepository.existsSellerById(anyInt())).thenReturn(false);

        //Assert + Act
        assertThrows(NotFoundException.class,()-> socialMeliService.unfollowSeller(userId,userIdToUnFollow));
    }

    @Test
    @DisplayName("US-0007 - NotFound Exception when Buyer not exist (T-0002)")
    void unfollowSellerThrowNotFoundExceptionWhenBuyerDoesNotExist(){
        //Arrange
        Integer userId = 2;
        Integer userIdToUnFollow = 10;
        when(userRepository.existsSellerById(anyInt())).thenReturn(true); //Necesito que pase este, asi va a la siguiente linea
        when(userRepository.existsBuyerById(anyInt())).thenReturn(false);



        //Assert + Act
        assertThrows(NotFoundException.class,()-> socialMeliService.followSeller(userId,userIdToUnFollow));
    }

    @Test
    @DisplayName("US-0007 - NotFound Exception when Buyer already follow Seller (T-0002)")
    void unfollowSellerThrowBadRequestExceptionWhenBuyerAlreadyFollowsSeller(){
        //Arrange
        Integer userId = 2;
        Integer userIdToUnFollow = 10;
        when(userRepository.existsSellerById(anyInt())).thenReturn(true); //Necesito que pase este, asi va a la siguiente linea
        when(userRepository.existsBuyerById(anyInt())).thenReturn(true);
        when(userRepository.buyerAlreadyFollowsSeller(anyInt(),anyInt())).thenReturn(false);

        //Assert + Act
        assertThrows(BadRequestException.class,()-> socialMeliService.unfollowSeller(userId,userIdToUnFollow));
    }

    @DisplayName("US-0002 - Happy path with many followers (T-0007)")
    @Test
    void calculateSellerFollowerCount(){
        //arrange
        Integer sellerId = 1;
        String sellerName = "Juan";
        Seller seller = Seller.builder().id(sellerId).name(sellerName).build();

        List<Buyer> buyerList = List.of(Buyer.builder().build(),Buyer.builder().build());

        FollowerCountDTO expected = new FollowerCountDTO(sellerId,sellerName, (long) buyerList.size());

        when(userRepository.existsSellerById(sellerId)).thenReturn(true);
        when(userRepository.getSellerById(sellerId)).thenReturn(seller);
        when(userRepository.getBuyersFollowingSeller(sellerId)).thenReturn(buyerList);

        //act

        FollowerCountDTO obtained = socialMeliService.calculateSellerFollowerCount(sellerId);

        //assert
        assertEquals(expected,obtained);
    }

    @DisplayName("US-0002 - Seller not found (T-0007)")
    @Test
    void calculateSellerFollowerCountNotFound(){
        //arrange
        Integer sellerId = 1;

        when(userRepository.existsSellerById(sellerId)).thenReturn(false);

        //act & assert
        assertThrows(NotFoundException.class, () -> socialMeliService.calculateSellerFollowerCount(sellerId));
    }

    @DisplayName("US-0002 - Happy path with many followers (T-0007)")
    @Test
    void calculateSellerFollowerCountEqual0(){
        //arrange
        Integer sellerId = 1;
        String sellerName = "Juan";
        Seller seller = Seller.builder().id(sellerId).name(sellerName).build();

        List<Buyer> buyerList = new ArrayList<>();

        FollowerCountDTO expected = new FollowerCountDTO(sellerId,sellerName, (long) buyerList.size());

        when(userRepository.existsSellerById(sellerId)).thenReturn(true);
        when(userRepository.getSellerById(sellerId)).thenReturn(seller);
        when(userRepository.getBuyersFollowingSeller(sellerId)).thenReturn(buyerList);

        //act
        FollowerCountDTO obtained = socialMeliService.calculateSellerFollowerCount(sellerId);

        //assert
        assertEquals(expected,obtained);
    }

    @Test
    @DisplayName("US-0008 - Validar el ordenamiento descendente en usuarios seguidos (T-0004)")
    public void testGetFollowedSellersWithDescendingOrder() {
        // Arrange
        List<Seller> mockFollowedSellers = Arrays.asList(
                Seller.builder().id(2).name("Lucas").build(),
                Seller.builder().id(3).name("Guido").build(),
                Seller.builder().id(4).name("Juan").build()
        );

        Buyer mockBuyer = Buyer.builder().id(1).name("Carlos").sellers(mockFollowedSellers).build();

        when(userRepository.getBuyerById(1)).thenReturn(mockBuyer);
        when(userRepository.getSellersFollowedByBuyer(1)).thenReturn(mockFollowedSellers);

        // Act
        BuyerFollowedSellersDto result = socialMeliService.getUserFollowSellers(1, "name_desc");

        // Assert - Verificar orden descendente
        assertEquals("Lucas", result.getFollowed().get(0).getUserName());
        assertEquals("Juan", result.getFollowed().get(1).getUserName());
        assertEquals("Guido", result.getFollowed().get(2).getUserName());
    }

    @Test
    @DisplayName("US-0008 - Verificar que el ordenamiento alfabético válido funciona correctamente (T-0003)")
    public void testGetFollowersWithValidOrder() {
        // Arrange
        List<Buyer> mockFollowerList = Arrays.asList(
                Buyer.builder().id(2).name("Lucas").sellers(new ArrayList<>()).build(),
                Buyer.builder().id(3).name("Guido").sellers(new ArrayList<>()).build(),
                Buyer.builder().id(4).name("Juan").sellers(new ArrayList<>()).build()
        );

        Seller mockSeller = Seller.builder()
                .id(1)
                .name("Vendedor A")
                .posts(new ArrayList<>())
                .build();

        when(userRepository.getSellerById(1)).thenReturn(mockSeller);
        when(userRepository.getFollowers(1)).thenReturn(mockFollowerList);

        // Act
        UserFollowersDTO resultAsc = socialMeliService.getSellerFollowers(1, "name_asc");
        UserFollowersDTO resultDesc = socialMeliService.getSellerFollowers(1, "name_desc");

        // Assert - verificamos el orden ASC
        assertEquals("Guido", resultAsc.getFollowers().get(0).getUserName());
        assertEquals("Juan", resultAsc.getFollowers().get(1).getUserName());
        assertEquals("Lucas", resultAsc.getFollowers().get(2).getUserName());

        // Assert - verificamos el  orden DESC
        assertEquals("Lucas", resultDesc.getFollowers().get(0).getUserName());
        assertEquals("Juan", resultDesc.getFollowers().get(1).getUserName());
        assertEquals("Guido", resultDesc.getFollowers().get(2).getUserName());
    }

    @Test
    @DisplayName("US-0008 - Verificar que se lanza una excepción con ordenamiento inválido (T-0003)")
    public void testGetFollowersWithInvalidOrder() {
        // Arrange
        List<Buyer> mockFollowerList = Arrays.asList(
                Buyer.builder().id(2).name("Lucas").sellers(new ArrayList<>()).build(),
                Buyer.builder().id(3).name("Guido").sellers(new ArrayList<>()).build(),
                Buyer.builder().id(4).name("Juan").sellers(new ArrayList<>()).build()
        );

        Seller mockSeller = Seller.builder()
                .id(1)
                .name("Vendedor A")
                .posts(new ArrayList<>())
                .build();

        when(userRepository.getSellerById(1)).thenReturn(mockSeller);
        when(userRepository.getFollowers(1)).thenReturn(mockFollowerList);

        // Assert - verificamos que al pasar un orden inválido tira excepción
        assertThrows(BadRequestException.class, () -> socialMeliService.getSellerFollowers(1, "invalid_order"));
    }

    @Test
    @DisplayName("US-0008 - Verificar que el ordenamiento alfabético válido funciona correctamente en usuarios seguidos (T-0003)")
    public void testGetFollowedSellersWithValidOrder() {
        // Arrange
        List<Seller> mockFollowedSellers = Arrays.asList(
                Seller.builder().id(2).name("Lucas").build(),
                Seller.builder().id(3).name("Guido").build(),
                Seller.builder().id(4).name("Juan").build()
        );

        Buyer mockBuyer = Buyer.builder().id(1).name("Carlos").sellers(mockFollowedSellers).build();

        when(userRepository.getBuyerById(1)).thenReturn(mockBuyer);
        when(userRepository.getSellersFollowedByBuyer(1)).thenReturn(mockFollowedSellers);

        // Act
        BuyerFollowedSellersDto resultAsc = socialMeliService.getUserFollowSellers(1, "name_asc");
        BuyerFollowedSellersDto resultDesc = socialMeliService.getUserFollowSellers(1, "name_desc");

        // Assert - Verificar orden ascendente
        assertEquals("Guido", resultAsc.getFollowed().get(0).getUserName());
        assertEquals("Juan", resultAsc.getFollowed().get(1).getUserName());
        assertEquals("Lucas", resultAsc.getFollowed().get(2).getUserName());

        // Assert - Verificar orden descendente
        assertEquals("Lucas", resultDesc.getFollowed().get(0).getUserName());
        assertEquals("Juan", resultDesc.getFollowed().get(1).getUserName());
        assertEquals("Guido", resultDesc.getFollowed().get(2).getUserName());
    }

    @Test
    @DisplayName("US-0008 - Verificar que se lanza una excepción con ordenamiento inválido en usuarios seguidos (T-0003)")
    public void testGetFollowedSellersWithInvalidOrder() {
        // Arrange
        List<Seller> mockFollowedSellers = Arrays.asList(
                Seller.builder().id(2).name("Lucas").build(),
                Seller.builder().id(3).name("Guido").build(),
                Seller.builder().id(4).name("Juan").build()
        );

        Buyer mockBuyer = Buyer.builder().id(1).name("Carlos").sellers(mockFollowedSellers).build();

        when(userRepository.getBuyerById(1)).thenReturn(mockBuyer);
        when(userRepository.getSellersFollowedByBuyer(1)).thenReturn(mockFollowedSellers);

        // Assert
        assertThrows(BadRequestException.class, () -> socialMeliService.getUserFollowSellers(1, "invalid_order"));
    }

    @Test
    @DisplayName("US-0008 - Validar el ordenamiento ascendente en seguidores (T-0004)")
    public void testGetFollowersWithAscendingOrder() {
        // Arrange
        List<Buyer> mockFollowerList = Arrays.asList(
                Buyer.builder().id(2).name("Lucas").sellers(new ArrayList<>()).build(),
                Buyer.builder().id(4).name("Juan").sellers(new ArrayList<>()).build(),
                Buyer.builder().id(3).name("Guido").sellers(new ArrayList<>()).build()
        );

        Seller mockSeller = Seller.builder()
                .id(1)
                .name("Vendedor A")
                .posts(new ArrayList<>())
                .build();

        when(userRepository.getSellerById(1)).thenReturn(mockSeller);
        when(userRepository.getFollowers(1)).thenReturn(mockFollowerList);

        // Act
        UserFollowersDTO result = socialMeliService.getSellerFollowers(1, "name_asc");

        // Assert verificamos el orden ascendente
        assertEquals("Guido", result.getFollowers().get(0).getUserName());
        assertEquals("Juan", result.getFollowers().get(1).getUserName());
        assertEquals("Lucas", result.getFollowers().get(2).getUserName());
    }

    @Test
    @DisplayName("US-0008 - Validar el ordenamiento descendente en seguidores (T-0004)")
    public void testGetFollowersWithDescendingOrder() {
        // Arrange
        List<Buyer> mockFollowerList = Arrays.asList(
                Buyer.builder().id(3).name("Guido").sellers(new ArrayList<>()).build(),
                Buyer.builder().id(4).name("Juan").sellers(new ArrayList<>()).build(),
                Buyer.builder().id(2).name("Lucas").sellers(new ArrayList<>()).build()
        );

        Seller mockSeller = Seller.builder()
                .id(1)
                .name("Vendedor A")
                .posts(new ArrayList<>())
                .build();

        // mockeamos que el vendedor existe y tiene seguidores
        when(userRepository.getSellerById(1)).thenReturn(mockSeller);
        when(userRepository.getFollowers(1)).thenReturn(mockFollowerList);

        // Act
        UserFollowersDTO result = socialMeliService.getSellerFollowers(1, "name_desc");

        // Assert - verificamos orden descendente
        assertEquals("Lucas", result.getFollowers().get(0).getUserName());
        assertEquals("Juan", result.getFollowers().get(1).getUserName());
        assertEquals("Guido", result.getFollowers().get(2).getUserName());
    }

    @Test
    @DisplayName("US-0008 - Validar el ordenamiento ascendente en usuarios seguidos (T-0004)")
    public void testGetFollowedSellersWithAscendingOrder() {
        // Arrange
        List<Seller> mockFollowedSellers = Arrays.asList(
                Seller.builder().id(2).name("Lucas").build(),
                Seller.builder().id(3).name("Guido").build(),
                Seller.builder().id(4).name("Juan").build()
        );

        Buyer mockBuyer = Buyer.builder().id(1).name("Carlos").sellers(mockFollowedSellers).build();

        when(userRepository.getBuyerById(1)).thenReturn(mockBuyer);
        when(userRepository.getSellersFollowedByBuyer(1)).thenReturn(mockFollowedSellers);

        // Act
        BuyerFollowedSellersDto result = socialMeliService.getUserFollowSellers(1, "name_asc");

        // Assert - Verificar orden ascendente
        assertEquals("Guido", result.getFollowed().get(0).getUserName());
        assertEquals("Juan", result.getFollowed().get(1).getUserName());
        assertEquals("Lucas", result.getFollowed().get(2).getUserName());
    }

    @Test
    @DisplayName("US-0009 - Ordenamiento Descendente (T-0005) y (T-0006)")
    void searchPostsByUserIdInLastTwoWeeksOrderDescOK() {
        //Arrange
        List<Seller> sellers = List.of(Seller.builder().build());
        List<Post> orderedPosts = List.of(
                new Post(1, LocalDate.now(), new Product(), null, null, null, null),
                new Post(2, LocalDate.now().minusDays(2), new Product(), null, null, null, null)
        );

        when(userRepository.existsBuyerById(anyInt())).thenReturn(true);
        when(userRepository.getSellersFollowedByBuyer(anyInt())).thenReturn(sellers);
        when(userRepository.findPostsFromSellerByUserIdWithLimitDate(anyInt(), any(LocalDate.class))).thenReturn(orderedPosts);

        //Act
        PostsByUserResponseDto response = socialMeliService.searchPostsByUserIdInLastTwoWeeks(1, "date_desc");

        //Assert
        assertEquals(1, response.getPosts().getFirst().getPostId());
        assertEquals(2, response.getPosts().getLast().getPostId());
    }

    @Test
    @DisplayName("US-0009 - Ordenamiento Ascendente (T-0006)")
    void searchPostsByUserIdInLastTwoWeeksOrderAscOK() {
        //Arrange
        List<Seller> sellers = List.of(Seller.builder().build());
        List<Post> orderedPosts = List.of(
                new Post(1, LocalDate.now(), new Product(), null, null, null, null),
                new Post(2, LocalDate.now().minusDays(2), new Product(), null, null, null, null)
        );

        when(userRepository.existsBuyerById(anyInt())).thenReturn(true);
        when(userRepository.getSellersFollowedByBuyer(anyInt())).thenReturn(sellers);
        when(userRepository.findPostsFromSellerByUserIdWithLimitDate(anyInt(), any(LocalDate.class))).thenReturn(orderedPosts);

        //Act
        PostsByUserResponseDto response = socialMeliService.searchPostsByUserIdInLastTwoWeeks(1, "date_asc");

        //Assert
        assertEquals(2, response.getPosts().getFirst().getPostId());
        assertEquals(1, response.getPosts().getLast().getPostId());

    }

    @Test
    @DisplayName("US-0009 - Ordenamiento Descendente no se cumple (T-0006)")
    void searchPostsByUserIdInLastTwoWeeksOrderDescWithInvalidBuyer() {
        //Arrange
        when(userRepository.existsBuyerById(anyInt())).thenReturn(false);

        // Act y Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                socialMeliService.searchPostsByUserIdInLastTwoWeeks(1, "date_desc")
        );
        assertEquals("No existe el usuario", exception.getMessage());
    }

    @Test
    @DisplayName("US-0009 - Ordenamiento Descendente no se cumple cuando el comprador no sigue vendedores (T-0006)")
    void searchPostsByUserIdInLastTwoWeeksOrderWhenUserDoesNotFollowSellers() {
        //Arrange
        List<Seller> sellers = List.of();

        when(userRepository.existsBuyerById(anyInt())).thenReturn(true);
        when(userRepository.getSellersFollowedByBuyer(anyInt())).thenReturn(sellers);

        // Act y Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                socialMeliService.searchPostsByUserIdInLastTwoWeeks(1, "date_desc")
        );
        assertEquals("El usuario no sigue vendedores", exception.getMessage());
    }

    @Test
    @DisplayName("US-0009 - Ordenamiento Descendente no se cumple cuando el comprador no sigue vendedores (T-0006)")
    void searchPostsByUserIdInLastTwoWeeksOrderWhenNoPostsToDisplay() {
        //Arrange
        List<Seller> sellers = List.of(Seller.builder().build());

        when(userRepository.existsBuyerById(anyInt())).thenReturn(true);
        when(userRepository.getSellersFollowedByBuyer(anyInt())).thenReturn(sellers);

        // Act y Assert
        NotFoundException exception = assertThrows(NotFoundException.class, () ->
                socialMeliService.searchPostsByUserIdInLastTwoWeeks(1, "date_desc")
        );
        assertEquals("No hay posts para mostrar", exception.getMessage());
    }
}