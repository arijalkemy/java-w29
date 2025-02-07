package com.thiagoschreck.local.melisocial.service;

import com.thiagoschreck.local.melisocial.dto.request.CreateUserRequestDTO;
import com.thiagoschreck.local.melisocial.dto.response.CreateUserResponseDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.ClientDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerFollowersCountDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.UserInfoDTO;
import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import com.thiagoschreck.local.melisocial.exception.ClientNotFoundException;
import com.thiagoschreck.local.melisocial.exception.InvalidSortOrderException;
import com.thiagoschreck.local.melisocial.exception.SellerNotFoundException;
import com.thiagoschreck.local.melisocial.exception.UserAlreadyFollowingSellerException;
import com.thiagoschreck.local.melisocial.exception.UserNotFollowingSellerException;
import com.thiagoschreck.local.melisocial.repository.IUsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceTests {
    @Mock
    private IUsersRepository repository;

    @InjectMocks
    private UsersServiceImpl service;

    @Test
    @DisplayName("Given client sends valid information When client unfollows seller Then they are removed from their lists")
    void testSuccessfulUnfollow() {
        // ARRANGE
        // Valid Client and seller
        Client client = new Client("Client");
        Seller seller = new Seller("Seller");
        client.setUserId(0);
        seller.setUserId(0);
        client.getFollowing().add(seller);
        seller.getFollowers().add(client);

        Mockito.when(repository.findClientById(anyInt())).thenReturn(Optional.of(client));
        Mockito.when(repository.findSellerById(anyInt())).thenReturn(Optional.of(seller));
        // ACT
        ClientDTO dto = service.unfollowSeller(0, 0);
        // ASSERT
        assertEquals(0, dto.userId());
        assertEquals("Client", dto.userName());
        assertEquals(List.of(), dto.followed());
    }

    @Test
    @DisplayName("Given client id doesnt exist When client unfollows seller Then ClientNotFoundException is thrown")
    void testUnfollowClientNotFound() {
        // ARRANGE
        Mockito.when(repository.findClientById(anyInt())).thenReturn(Optional.empty());
        // ACT
        // ASSERT
        assertThrows(ClientNotFoundException.class, () -> service.unfollowSeller(0, 0));
    }

    @Test
    @DisplayName("Given seller id doesnt exist When client unfollows seller Then SellerNotFoundException is thrown")
    void testUnfollowSellerNotFound() {
        // ARRANGE
        Client client = new Client("Client");
        client.setUserId(0);

        Mockito.when(repository.findClientById(anyInt())).thenReturn(Optional.of(client));
        Mockito.when(repository.findSellerById(anyInt())).thenReturn(Optional.empty());
        // ACT
        // ASSERT
        assertThrows(SellerNotFoundException.class, () -> service.unfollowSeller(0, 0));
    }

    @Test
    @DisplayName("Given client doesnt follow seller When client unfollows seller Then UserNotFollowingSellerException is thrown")
    void testUnfollowAlreadyNotFollowing() {
        // ARRANGE
        // Valid Client and seller
        Client client = new Client("Client");
        Seller seller = new Seller("Seller");
        client.setUserId(0);
        seller.setUserId(0);

        Mockito.when(repository.findClientById(anyInt())).thenReturn(Optional.of(client));
        Mockito.when(repository.findSellerById(anyInt())).thenReturn(Optional.of(seller));
        // ACT
        // ASSERT
        assertThrows(UserNotFollowingSellerException.class, () -> service.unfollowSeller(0, 0));
    }

    @Test
    void getSellerFollowersByUserIdInvalidOrderTest() {
        //ARRANGE
        String order = "invalid-order";

        //ACT
        //ASSERT
        Assertions.assertThrows(
                InvalidSortOrderException.class,
                () -> service.getSellerFollowersByUserId(1, order)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"name_asc", "name_desc"})
    void getSellerFollowersByUserId(String order) {
        //ARRANGE
        Seller seller = new Seller("Seller");
        seller.setUserId(1);

        Client client1 = new Client("Client 1");
        client1.setUserId(2);

        Client client2 = new Client("Client 2");
        client2.setUserId(3);

        seller.addFollower(client1);
        seller.addFollower(client2);

        SellerDTO expectedDTO = new SellerDTO(
                seller.getUserId(),
                seller.getUserName(),
                List.of(
                        new UserInfoDTO(
                                client1.getUserId(),
                                client1.getUserName()
                        ),
                        new UserInfoDTO(
                                client2.getUserId(),
                                client2.getUserName()
                        )
                )
        );

        when(repository.findSellerById(anyInt(), anyString())).thenReturn(Optional.of(seller));

        //ACT
        SellerDTO actual = service.getSellerFollowersByUserId(seller.getUserId(), order);

        //ASSERT
        Assertions.assertEquals(expectedDTO, actual);
    }

    @Test
    void getClientFollowedSellersOrderAsc() {
        //ARRANGE
        Client client = new Client("Client");
        client.setUserId(1);

        Seller seller1 = new Seller("Seller 1");
        seller1.setUserId(2);

        Seller seller2 = new Seller("Seller 2");
        seller2.setUserId(3);

        client.followSeller(seller1);
        client.followSeller(seller2);

        ClientDTO expectedDTO = new ClientDTO(
                client.getUserId(),
                client.getUserName(),
                List.of(
                        new UserInfoDTO(
                                seller1.getUserId(),
                                seller1.getUserName()
                        ),
                        new UserInfoDTO(
                                seller2.getUserId(),
                                seller2.getUserName()
                        )
                )
        );

        when(repository.findClientById(anyInt(), anyString())).thenReturn(Optional.of(client));

        //ACT
        ClientDTO actual = service.getClientFollowedSellersByUserId(client.getUserId(), "name_asc");

        //ASSERT
        Assertions.assertEquals(expectedDTO, actual);
    }

    @Test
    void getClientFollowedSellersOrderDesc() {
        //ARRANGE
        Client client = new Client("Client");
        client.setUserId(1);

        Seller seller1 = new Seller("Seller 1");
        seller1.setUserId(2);

        Seller seller2 = new Seller("Seller 2");
        seller2.setUserId(3);

        client.followSeller(seller2);
        client.followSeller(seller1);

        ClientDTO expectedDTO = new ClientDTO(
                client.getUserId(),
                client.getUserName(),
                List.of(
                        new UserInfoDTO(
                                seller2.getUserId(),
                                seller2.getUserName()
                        ),
                        new UserInfoDTO(
                                seller1.getUserId(),
                                seller1.getUserName()
                        )
                )
        );

        when(repository.findClientById(anyInt(), anyString())).thenReturn(Optional.of(client));

        //ACT
        ClientDTO actual = service.getClientFollowedSellersByUserId(client.getUserId(), "name_asc");

        //ASSERT
        Assertions.assertEquals(expectedDTO, actual);
    }

    @Test
    void follow_ClientDoesNotExist() {
        //Arrange/Act/Assert
        assertThrows(ClientNotFoundException.class, () -> service.followSeller(1, 1));
    }

    @Test
    void follow_SellerDoesNotExist() {
        //Arrange
        Client client = new Client("Cliente");
        Mockito.when(repository.findClientById(anyInt())).thenReturn(Optional.of(client));
        Mockito.when(repository.findSellerById(anyInt())).thenReturn(Optional.empty());
        //Act/Assert
        assertThrows(SellerNotFoundException.class, () -> service.followSeller(1, 1));
    }

    @Test
    void follow_ClientFollowAlreadySeller() {
        //Arrange
        Client client = new Client("Cliente");
        Seller seller = new Seller("Seller");
        client.setUserId(1);
        seller.setUserId(1);
        client.getFollowing().add(seller);
        seller.getFollowers().add(client);
        Mockito.when(repository.findClientById(anyInt())).thenReturn(Optional.of(client));
        Mockito.when(repository.findSellerById(anyInt())).thenReturn(Optional.of(seller));
        //Act
        //Assert
        assertThrows(UserAlreadyFollowingSellerException.class, () -> service.followSeller(1, 1));
    }

    @Test
    void followSeller() {
        //Arrange
        Client client = new Client("Cliente");
        Seller seller = new Seller("Seller");
        client.setUserId(1);
        seller.setUserId(2);

        Mockito.when(repository.findClientById(anyInt())).thenReturn(Optional.of(client));
        Mockito.when(repository.findSellerById(anyInt())).thenReturn(Optional.of(seller));
        //Act
        ClientDTO dto = service.followSeller(1, 2);
        //Assert
        assertEquals(1, dto.userId());
        assertEquals("Cliente", dto.userName());
        assertEquals(seller.getUserId(), dto.followed().getFirst().userId());
    }

    @Test
    void getSellerFollowersCount() {
        //Arrange
        Seller seller = new Seller("Seller");
        seller.setUserId(1);

        Client client1 = new Client("Client 1");
        client1.setUserId(2);

        Client client2 = new Client("Client 2");
        client2.setUserId(3);

        seller.addFollower(client1);
        seller.addFollower(client2);

        when(repository.findSellerById(anyInt())).thenReturn(Optional.of(seller));
        SellerFollowersCountDTO expected = new SellerFollowersCountDTO(
                seller.getUserId(),
                seller.getUserName(),
                seller.getFollowers().size()
        );
        //Act
        SellerFollowersCountDTO actual = service.getSellerFollowersCount(seller.getUserId());

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void getSellerFollowersCountWhenSellerNotFound() {
        when(repository.findSellerById(anyInt())).thenReturn(Optional.empty());
        assertThrows(SellerNotFoundException.class, () -> service.getSellerFollowersCount(1));
    }

    @Test
    void createClient() {
        Client clientInput = new Client("Johnny Test");
        Client clientFromRepository = new Client(clientInput.getUserName().trim().replace(" ", "_"));
        clientFromRepository.setUserId(0);
        when(repository.save(clientInput)).thenReturn(clientFromRepository);

        CreateUserResponseDTO actual = service.createClient(new CreateUserRequestDTO(clientInput.getUserName()));
        CreateUserResponseDTO expected = new CreateUserResponseDTO(clientFromRepository.getUserId(),
                clientFromRepository.getUserName());
        assertEquals(expected, actual);
    }

    @Test
    void createSeller() {
        Seller sellerInput = new Seller("Johnny Test");
        Seller sellerFromRepository = new Seller(sellerInput.getUserName().trim().replace(" ", "_"));
        sellerFromRepository.setUserId(0);
        when(repository.save(sellerInput)).thenReturn(sellerFromRepository);

        CreateUserResponseDTO actual = service.createSeller(new CreateUserRequestDTO(sellerInput.getUserName()));
        CreateUserResponseDTO expected = new CreateUserResponseDTO(sellerFromRepository.getUserId(),
                sellerFromRepository.getUserName());
        assertEquals(expected, actual);
    }

    @Test
    void getClientFollowedSellersWhenClientNotFound() {
        when(repository.findClientById(anyInt(), anyString())).thenReturn(Optional.empty());
        assertThrows(ClientNotFoundException.class, () -> service.getClientFollowedSellersByUserId(1, "name_asc"));
    }

    @Test
    void getClientFollowedSellersInvalidOrder() {
        assertThrows(InvalidSortOrderException.class, () -> service.getClientFollowedSellersByUserId(1, "invalid-order"));
    }
}
