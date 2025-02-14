package com.meli.socialmeli.service;

import com.meli.socialmeli.constants.Messages;
import com.meli.socialmeli.dto.FollowedDto;
import com.meli.socialmeli.dto.FollowedListResponseDto;
import com.meli.socialmeli.dto.FollowersDto;
import com.meli.socialmeli.dto.UserDto;
import com.meli.socialmeli.dto.SellerDto;
import com.meli.socialmeli.entity.Seller;
import com.meli.socialmeli.entity.User;
import com.meli.socialmeli.exception.NotFoundOrderException;
import com.meli.socialmeli.repository.ISellerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SellerServiceImplTest {

    private static final int SELLER_ID = 1;
    private static final String SELLER_NAME = "seller";

    @Mock
    private ISellerRepository sellerRepository;

    @InjectMocks
    private SellerServiceImpl sellerService;

    private List<User> testUsers;
    private Seller testSeller;
    private Seller seller;

    @BeforeEach
    void setUp() {
        testUsers = createTestUsers();
        testSeller = createTestSeller();
        mockSellerRepository();

        // Crear vendedores
        User user1 = new User(1, "Carlos", List.of());
        User user2 = new User(2, "Ana", List.of());
        User user3 = new User(3, "Beatriz", List.of());

        // Crear un usuario de prueba
        seller = new Seller();
        seller.setId(1);
        seller.setName("SellerTest");
        seller.setFollowers(Arrays.asList(user1, user2, user3));

    }


    @Test
    @DisplayName("T-0002: Should successfully get followers count")
    void countFollowersOk() {
        //Arrange
        when(sellerRepository.getById(SELLER_ID)).thenReturn(Optional.of(testSeller));

        //Act
        SellerDto response = sellerService.countFollowers(SELLER_ID);

        //Assert
        verify(sellerRepository).getById(SELLER_ID);
        assertEquals(SELLER_NAME, response.getUser_name());
        assertEquals(testSeller.getFollowers().size(), response.getFollowers_count());
    }

    @Test
    @DisplayName("T-0003: Should successfully get followers with valid order parameters")
    void getFollowersBySellerIdOk() {
        // Arrange
        List<String> validOrders = Arrays.asList("name_asc", "name_desc");

        // Act & Assert
        validOrders.forEach(order ->
                assertDoesNotThrow(() -> sellerService.getFollowersBySellerId(SELLER_ID, order))
        );
    }

    @Test
    @DisplayName("T-0003: Should throw exception with invalid order parameters")
    void getFollowersBySellerIdException() {
        // Arrange
        List<String> invalidOrders = Arrays.asList("invalid_order", "name_non", " ");

        // Act & Assert
        invalidOrders.forEach(order ->
                assertThrows(NotFoundOrderException.class,
                        () -> sellerService.getFollowersBySellerId(SELLER_ID, order))
        );
    }

    @Test
    @DisplayName("T-0004: Order es descendente.")
    void testOrderDescendente() {
        // Simular el comportamiento del repositorio para devolver el vendedor
        when(sellerRepository.getById(1)).thenReturn(Optional.of(seller));

        FollowersDto response = sellerService.getFollowersBySellerId(1, "name_desc");
        List<UserDto> followers = response.getFollowers();

        assertEquals("Carlos", followers.get(0).getUser_name());
        assertEquals("Beatriz", followers.get(1).getUser_name());
        assertEquals("Ana", followers.get(2).getUser_name());
    }

    @Test
    @DisplayName("T-0004: Order es ascendente.")
    void testOrderAscendente() {
        // Simular el comportamiento del repositorio para devolver el vendedor
        when(sellerRepository.getById(1)).thenReturn(Optional.of(seller));

        FollowersDto response = sellerService.getFollowersBySellerId(1, "name_asc" );
        List<UserDto> followers = response.getFollowers();

        assertEquals("Ana", followers.get(0).getUser_name());
        assertEquals("Beatriz", followers.get(1).getUser_name());
        assertEquals("Carlos", followers.get(2).getUser_name());
    }

    @Test
    @DisplayName("T-0004: Order es invalido.")
    void testOrderInvalido() {
        // Simular el comportamiento del repositorio para devolver el vendedor
        when(sellerRepository.getById(1)).thenReturn(Optional.of(seller));
        assertThrows(NotFoundOrderException.class, () ->
                sellerService.getFollowersBySellerId(1, "El orden no es válido"), Messages.ORDER_NOT_FOUND);
    }

    private List<User> createTestUsers() {
        return Arrays.asList(
                new User(1, "Pepito", new ArrayList<>()),
                new User(2, "Juanito", new ArrayList<>())
        );
    }

    private Seller createTestSeller() {
        return new Seller(SELLER_ID, SELLER_NAME, new ArrayList<>(testUsers));
    }

    private void mockSellerRepository() {
        when(sellerRepository.getById(SELLER_ID))
                .thenReturn(Optional.of(testSeller));
    }

}