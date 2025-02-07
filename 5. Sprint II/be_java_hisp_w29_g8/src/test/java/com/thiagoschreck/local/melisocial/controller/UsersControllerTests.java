package com.thiagoschreck.local.melisocial.controller;

import com.thiagoschreck.local.melisocial.dto.request.CreateUserRequestDTO;
import com.thiagoschreck.local.melisocial.dto.response.CreateUserResponseDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.ClientDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.UserInfoDTO;
import com.thiagoschreck.local.melisocial.service.IUsersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersControllerTests {

    @Mock
    private IUsersService service;

    @InjectMocks
    private UsersController controller;

    @Test
    void getSellerFollowers() {
        //ARRANGE
        SellerDTO seller = new SellerDTO(
                1,
                "Seller",
                List.of(
                        new UserInfoDTO(1, "Client 1"),
                        new UserInfoDTO(2, "Client 2")
                )
        );
        ResponseEntity<SellerDTO> expected = ResponseEntity.ok(seller);

        when(service.getSellerFollowersByUserId(anyInt(), anyString())).thenReturn(seller);

        //ACT
        ResponseEntity<SellerDTO> actual = controller.getSellerFollowers(1, "order");

        //ASSERT
        verify(service, atLeastOnce()).getSellerFollowersByUserId(1, "order");
        assertEquals(expected, actual);
    }

    @Test
    void getClientFollowedSellers() {
        //ARRANGE
        ClientDTO client = new ClientDTO(
                1,
                "Client",
                List.of(
                        new UserInfoDTO(1, "Seller 1"),
                        new UserInfoDTO(2, "Seller 2")
                )
        );
        ResponseEntity<ClientDTO> expected = ResponseEntity.ok(client);

        when(service.getClientFollowedSellersByUserId(anyInt(), anyString())).thenReturn(client);

        //ACT
        ResponseEntity<ClientDTO> actual = controller.getClientFollowedSellers(1, "order");

        //ASSERT
        verify(service, atLeastOnce()).getClientFollowedSellersByUserId(1, "order");
        assertEquals(expected, actual);
    }

    @Test
    void createClient() {
        CreateUserRequestDTO request = new CreateUserRequestDTO("Johnny Test");
        when(service.createClient(request)).thenReturn(new CreateUserResponseDTO(0, request.userName()));
        controller.createClientResponseDTO(request);
        verify(service, times(1)).createClient(request);
    }

    @Test
    void createSeller() {
        CreateUserRequestDTO request = new CreateUserRequestDTO("Johnny Test");
        when(service.createSeller(request)).thenReturn(new CreateUserResponseDTO(0, request.userName()));
        controller.createSellerResponseDTO(request);
        verify(service, times(1)).createSeller(request);
    }
}
