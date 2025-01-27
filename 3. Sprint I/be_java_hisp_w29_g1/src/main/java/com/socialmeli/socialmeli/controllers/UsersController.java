package com.socialmeli.socialmeli.controllers;

import com.socialmeli.socialmeli.dto.response.*;
import com.socialmeli.socialmeli.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController {

    private final IUserService userService;

    // US 0001 - Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> followToUser(@PathVariable Integer userId, @PathVariable Integer userIdToFollow) {
        return ResponseEntity.ok(userService.follow(userId, userIdToFollow));
    }

    // US 0002 - Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDto> getCountFollowerForSeller(@PathVariable Integer userId) {
        return ResponseEntity.ok(userService.countFollowers(userId));
    }

    // US 0003 - Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowerListDto> getFollowerList(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "name_asc") String order
    ) {
        return ResponseEntity.ok(userService.getFollowerList(userId, order));
    }
    
    // US 0004 - Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDto> getFollowedUsers(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "name_asc") String order
    ) {
        return ResponseEntity.ok(userService.getFollowedList(userId, order));
    }

    // US 0007 - Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDto> unfollowUser(
            @PathVariable Integer userId,
            @PathVariable Integer userIdToUnfollow
    ) {
        return ResponseEntity.ok(userService.unfollow(userId, userIdToUnfollow));
    }


}
