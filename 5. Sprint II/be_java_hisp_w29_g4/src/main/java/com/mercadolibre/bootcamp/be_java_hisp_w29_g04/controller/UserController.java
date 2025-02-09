package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.controller;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowersCountDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowersDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.FollowingDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.UserOrderTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service.IUserService;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service.UserServiceImpl;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("/users")
@RestController
@AllArgsConstructor
@Validated
public class UserController {

    private final IUserService us;

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<MessageDto> followSeller(@PathVariable Integer userId,
                                          @PathVariable Integer userIdToFollow){
        return new ResponseEntity<>(us.followSeller(userId,userIdToFollow),HttpStatus.OK);
    }

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<MessageDto> unfollowSeller(@PathVariable  Integer userId,
                                            @PathVariable  Integer userIdToUnfollow){
        return new ResponseEntity<>(us.unfollowSeller(userId,userIdToUnfollow),HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowingDto> findFollowersByUser(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "UNORDERED") String order
    ){

        return new ResponseEntity<>(us.getSellersByUser(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowersDto> findFollowingsByUser(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "UNORDERED") String order
    ){
        return new ResponseEntity<>(us.getUsersBySeller(userId, order), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowersCountDto> findFollowersCountByUser(@PathVariable  Integer userId){
        return new ResponseEntity<>(us.getFollowersCount(userId), HttpStatus.OK);
    }

    // #------------------ CRUD CONTROLLERS ------------------#

    @GetMapping("")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(us.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Integer userId) {
        return new ResponseEntity<>(us.findDtoById(userId), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<MessageDto> deleteUser(@PathVariable Integer userId) {
        us.delete(userId);
        return new ResponseEntity<>(new MessageDto("User deleted successfully"), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId, @RequestBody @Valid UserDto user) {
        user.setUserId(userId); /* We make sure that is the correct userId */
        return new ResponseEntity<>(us.update(user), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
        return new ResponseEntity<>(us.save(user), HttpStatus.CREATED);
    }

}
