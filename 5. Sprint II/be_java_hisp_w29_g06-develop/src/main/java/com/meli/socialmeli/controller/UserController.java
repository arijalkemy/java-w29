package com.meli.socialmeli.controller;


import com.meli.socialmeli.constants.Endpoints;
import com.meli.socialmeli.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.meli.socialmeli.service.IUserService;

import com.meli.socialmeli.dto.response.ResponseDto;
import com.meli.socialmeli.service.ISellerService;
import com.meli.socialmeli.service.SellerServiceImpl;
import com.meli.socialmeli.service.UserServiceImpl;

@RequestMapping(Endpoints.BASE_USERS)
@RestController
public class UserController {

    private IUserService userService;
    private ISellerService sellerService;

    public UserController(
            UserServiceImpl userService,
            SellerServiceImpl sellerService
    ) {
        this.userService = userService;
        this.sellerService = sellerService;
    }

    @PostMapping(Endpoints.USERS_FOLLOW)
    public ResponseEntity<ResponseDto> followSeller(
            @PathVariable Integer userId,
            @PathVariable Integer sellerId
    ) {
        return new ResponseEntity<>(this.userService.followSeller(userId, sellerId), HttpStatus.OK);
    }

    @PostMapping(Endpoints.USERS_UNFOLLOW)
    public ResponseEntity<ResponseDto> unfollowSeller(
            @PathVariable Integer userId,
            @PathVariable(name="userIdToUnfollow") Integer sellerId
    ) {
        return new ResponseEntity<>(this.userService.unfollowSeller(userId, sellerId), HttpStatus.OK);
    }

    @GetMapping(Endpoints.USERS_FOLLOWERS_LIST)
    public ResponseEntity<?> listFollowersBySeller(
            @PathVariable(name="userId") Integer sellerId,
            @RequestParam(required=false, defaultValue = "name_asc") String order
    ) {
        return new ResponseEntity<>(sellerService.getFollowersBySellerId(sellerId, order), HttpStatus.OK);
    }

    @GetMapping(Endpoints.USERS_FOLLOWED_LIST)
    public ResponseEntity<?> listFollowed(
            @PathVariable Integer userId,
            @RequestParam(required = false, defaultValue = "name_asc") String order
    ) {
        return new ResponseEntity<>(userService.getFollowedList(userId, order), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        return new ResponseEntity<>(userService.add(userDto), HttpStatus.CREATED);
    }

}
