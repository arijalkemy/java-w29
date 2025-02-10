package com.bootcamp.be_java_hisp_w29_g3.controller;

import com.bootcamp.be_java_hisp_w29_g3.dto.request.BuyerFollowedSellersDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.response.*;
import com.bootcamp.be_java_hisp_w29_g3.service.ISocialMeliService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Validated
public class SocialMeliController {
    private final ISocialMeliService socialMeliService;


    public SocialMeliController(ISocialMeliService socialMeliService){
        this.socialMeliService = socialMeliService;
    }

    //UH 1
    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDto> followSeller(@PathVariable @Positive(message = "El id debe ser mayor a 0") Integer userId, @PathVariable @Positive(message = "El id debe ser mayor a 0") Integer userIdToFollow){
        return new ResponseEntity<>(socialMeliService.followSeller(userId,userIdToFollow),HttpStatus.OK);
    }

    //UH 7
    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UnfollowDto> unFollowSeller(@PathVariable @Positive(message = "El id debe ser mayor a 0")  Integer userId, @PathVariable @Positive(message = "El id debe ser mayor a 0")  Integer userIdToUnfollow){
        return new ResponseEntity<>(socialMeliService.unfollowSeller(userId,userIdToUnfollow),HttpStatus.OK);
    }

    //UH 4
    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<BuyerFollowedSellersDto>  getSellersFollowedByBuyer(@PathVariable @Positive(message = "El id debe ser mayor a 0") Integer userId,
                                                                              @RequestParam(required = false, defaultValue = "")
                                                                              @Pattern(regexp = "^(name_asc|name_desc)?$", message = "El valor del order debe ser 'name_asc' o 'name_desc'.")
                                                                              String order) {
        return new ResponseEntity<>(socialMeliService.getUserFollowSellers(userId,order),HttpStatus.OK) ;
    }

    // UH 11
    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoProductDto> getPromoProducts(@RequestParam @Positive(message = "El id debe ser mayor a 0") Integer user_id){
        return new ResponseEntity<>(socialMeliService.getPromoProducts(user_id),HttpStatus.OK);
    }

    //UH 2
    @GetMapping("/users/{sellerId}/followers/count")
    public ResponseEntity<FollowerCountDTO> getSellerFollowerCount(@PathVariable @Positive(message = "El id debe ser mayor a 0") Integer sellerId){
        return new ResponseEntity<>(socialMeliService.calculateSellerFollowerCount(sellerId),HttpStatus.OK);
    }

    //UH 5
    @PostMapping("/products/post")
    public ResponseEntity<PostResponseDto> createPost(@Valid @RequestBody PostRequestDto post) {
        return new ResponseEntity<>(socialMeliService.createPost(post), HttpStatus.OK);
    }

    //UH 10
    @PostMapping("/products/promo-post")
    public ResponseEntity<PostResponseDto> createPromoPost(@Valid @RequestBody PostRequestDto post) {
        return new ResponseEntity<>(socialMeliService.createPost(post), HttpStatus.OK);
    }

    //UH 3 y 8
    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getSellerFollowers(@PathVariable @Positive(message = "El id debe ser mayor a 0")  Integer userId,
                                                               @RequestParam(required = false, defaultValue = "")
                                                               @Pattern(regexp = "^(name_asc|name_desc)?$", message = "El valor del order debe ser 'name_asc' o 'name_desc'.")
                                                               String order) {
        return new ResponseEntity<>(socialMeliService.getSellerFollowers(userId, order), HttpStatus.OK);
    }

    //UH 6 y 9
    @GetMapping("products/followed/{userId}/list")
    public ResponseEntity<PostsByUserResponseDto> getPostsByUserIdInLastTwoWeeks(@PathVariable @Positive(message = "El id debe ser mayor a 0")  Integer userId,
                                                               @RequestParam(required = false, defaultValue = "date_desc")
                                                               @Pattern(regexp = "^(date_asc|date_desc)$", message = "El valor del order debe ser 'date_asc' o 'date_desc'.") String order) {
        return new ResponseEntity<>(socialMeliService.searchPostsByUserIdInLastTwoWeeks(userId, order), HttpStatus.OK);
    }

    //UH 13
    @GetMapping("/users/followers/most-popular")
    public ResponseEntity<List<FollowerCountDTO>> getSellersByFollowerCount(){
        return new ResponseEntity<>(socialMeliService.getSellersByFollowerCount(), HttpStatus.OK);
    }

    // UH 14
    @GetMapping("/products/promo-post/discount-range")
    public ResponseEntity<List<PostDto>> filterPostsByDiscountRange(@RequestParam Integer initialValue, @RequestParam Integer finalValue) {
        return new ResponseEntity<>(socialMeliService.filterPostsByDiscountRange(initialValue, finalValue), HttpStatus.OK);
    }
    //UH 12
    @GetMapping("/products/{product}/price/{minPrice}/{maxPrice}")
    public ResponseEntity<List<ProductFilterDto>> getProductByRangePrice(@PathVariable Double minPrice,
                                                                         @PathVariable Double maxPrice,
                                                                         @PathVariable String product){
        return new ResponseEntity<>(socialMeliService.getProductByRangePrice(minPrice,maxPrice, product),HttpStatus.OK);
    }

}
