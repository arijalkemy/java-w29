package com.socialmeli.socialmeli.controllers;

import com.socialmeli.socialmeli.dto.response.MessageDto;
import com.socialmeli.socialmeli.dto.response.UserFollowerCountDto;
import com.socialmeli.socialmeli.dto.response.FollowerListDto;
import com.socialmeli.socialmeli.dto.response.FollowedListDto;
import com.socialmeli.socialmeli.services.IUserService;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {

    private final IUserService userService;

    // US 0001 - Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> followToUser(
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.")
            @PathVariable Integer userId,
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.")
            @PathVariable Integer userIdToFollow) {
        return ResponseEntity.ok(userService.follow(userId, userIdToFollow));
    }

    // US 0002 - Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor.
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<UserFollowerCountDto> getCountFollowerForSeller(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.")
            Integer userId) {
        return ResponseEntity.ok(userService.countFollowers(userId));
    }

    // US 0003 - Obtener un listado de todos los usuarios que siguen a un determinado vendedor (¿Quién me sigue?).
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowerListDto> getFollowerList(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.")
            Integer userId,
            @RequestParam(defaultValue = "name_asc") @Pattern(regexp = "^(name_asc|name_desc)$",
                    message = "Invalid order. Allowed values are 'name_asc' or 'name_desc'.") String order) {
        return ResponseEntity.ok(userService.getFollowerList(userId, order));
    }

    // US 0004 - Obtener un listado de todos los vendedores a los cuales sigue un determinado usuario (¿A quién sigo?).
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDto> getFollowedUsers(
            @PathVariable
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.")
            Integer userId,
            @RequestParam(defaultValue = "name_asc") @Pattern(regexp = "^(name_asc|name_desc)$",
                    message = "Invalid order. Allowed values are 'name_asc' or 'name_desc'.") String order) {
        return ResponseEntity.ok(userService.getFollowedList(userId, order));
    }

    // US 0007 - Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado vendedor.
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDto> unfollowUser(
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.")
            @PathVariable Integer userId,
            @Positive(message = "El id debe ser mayor a cero.")
            @NotNull(message = "El  id no puede estar vacío.")
            @PathVariable Integer userIdToUnfollow) {
        return ResponseEntity.ok(userService.unfollow(userId, userIdToUnfollow));
    }
}
