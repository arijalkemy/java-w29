package com.app.controller;

import com.app.dto.response.*;
import com.app.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final IUserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.searchAll());
    }

    // US 0001
    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<SuccessDTO> followUser(@PathVariable int userId, @PathVariable int userIdToFollow) {
        return ResponseEntity.ok(userService.followUser(userId, userIdToFollow));
    }

    //US 0002
    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDTO> getFollowersCount(@PathVariable int userId) {
        return new ResponseEntity<>(userService.searchFollowersCount(userId), HttpStatus.OK);
    }

    // US 0003 // US 0008
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowerListDTO> getFollowersByUserId(
            @PathVariable int userId,
            @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity<>(userService.searchFollowerList(userId, order), HttpStatus.OK);
    }

    // US 0004 // US 0008
    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedListDTO> getFollowedByUserId(@PathVariable int userId,
                                                               @RequestParam(value = "order", required = false) String order) {
        return new ResponseEntity<>(userService.searchFollowedList(userId, order), HttpStatus.OK);
    }

    //US 0007
    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<SuccessDTO> deleteFollowedSeller(@PathVariable int userId, @PathVariable int userIdToUnfollow) {
        return new ResponseEntity<>(userService.deleteFollowedSeller(userId, userIdToUnfollow), HttpStatus.OK);
    }

}