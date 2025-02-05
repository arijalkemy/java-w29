package com.thiagoschreck.local.melisocial.controller;

import com.thiagoschreck.local.melisocial.dto.request.CreateUserRequestDTO;
import com.thiagoschreck.local.melisocial.dto.response.CreateUserResponseDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.ClientDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerFollowersCountDTO;
import com.thiagoschreck.local.melisocial.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final IUsersService usersService;

    @Autowired
    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<ClientDTO> unfollowSeller(@PathVariable Integer userId, @PathVariable Integer userIdToUnfollow) {
        return ResponseEntity.ok(usersService.unfollowSeller(userId, userIdToUnfollow));
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<ClientDTO> follow(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return ResponseEntity.ok(usersService.followSeller(userId, userIdToFollow));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerDTO> getSellerFollowers(
            @PathVariable int userId,
            @RequestParam(defaultValue = "name_asc") String order
    ) {
        return ResponseEntity.ok(usersService.getSellerFollowersByUserId(userId, order));
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<ClientDTO> getClientFollowedSellers(
            @PathVariable int userId,
            @RequestParam(defaultValue = "name_asc") String order
    ) {
        return ResponseEntity.ok(usersService.getClientFollowedSellersByUserId(userId, order));
    }

    @PostMapping("/clients")
    public ResponseEntity<CreateUserResponseDTO> createClientResponseDTO(@RequestBody CreateUserRequestDTO request) {
        return ResponseEntity.ok(usersService.createClient(request));
    }

    @PostMapping("/sellers")
    public ResponseEntity<CreateUserResponseDTO> createSellerResponseDTO(@RequestBody CreateUserRequestDTO request) {
        return ResponseEntity.ok(usersService.createSeller(request));
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowersCountDTO> getSellerFollowersCount(@PathVariable Integer userId) {
        return ResponseEntity.ok(usersService.getSellerFollowersCount(userId));
    }
}
