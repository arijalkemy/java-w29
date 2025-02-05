package com.bootcamp.be_java_hisp_w29_g3.controller;

import com.bootcamp.be_java_hisp_w29_g3.dto.BuyerFollowedSellersDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.response.*;
import com.bootcamp.be_java_hisp_w29_g3.service.ISocialMeliService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SocialMeliController {
    private final ISocialMeliService socialMeliService;


    public SocialMeliController(ISocialMeliService socialMeliService){
        this.socialMeliService = socialMeliService;
    }

    @PostMapping("/users/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<FollowDto> followSeller(@PathVariable int userId, @PathVariable int userIdToFollow){
        return new ResponseEntity<>(socialMeliService.followSeller(userId,userIdToFollow),HttpStatus.OK);
    }

    @PostMapping("/users/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<UnfollowDto> unFollowSeller(@PathVariable int userId, @PathVariable int userIdToUnfollow){
        return new ResponseEntity<>(socialMeliService.unfollowSeller(userId,userIdToUnfollow),HttpStatus.OK);
    }

    @GetMapping("/users/{userId}/followed/list")
    public ResponseEntity<BuyerFollowedSellersDto>  getSellersFollowedByBuyer(@PathVariable Integer userId) {
        return new ResponseEntity<>(socialMeliService.getUserFollowSellers(userId),HttpStatus.OK) ;
    }

    @GetMapping("/products/promo-post/count")
    public ResponseEntity<PromoProductDto> getPromoProducts(@RequestParam Integer user_id){
        return new ResponseEntity<>(socialMeliService.getPromoProducts(user_id),HttpStatus.OK);
    }

    @GetMapping("/users/{sellerId}/followers/count")
    public ResponseEntity<FollowerCountDTO> getSellerFollowerCount(@PathVariable Integer sellerId){
        return new ResponseEntity<>(socialMeliService.calculateSellerFollowerCount(sellerId),HttpStatus.OK);
    }

    @PostMapping("/products/post")
    public ResponseEntity<PostResponseDto> postPost(@RequestBody PostRequestDto post) {
        return new ResponseEntity<>(socialMeliService.createPost(post), HttpStatus.OK);
    }

    @PostMapping("/products/promo-post")
    public ResponseEntity<PostResponseDto> postPromoPost(@RequestBody PostRequestDto post) {
        return new ResponseEntity<>(socialMeliService.createPost(post), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<UserFollowersDTO> getFollowers(@PathVariable int userId, @RequestParam(required = false, defaultValue = "") String order) {
        return new ResponseEntity<>(socialMeliService.getFollowers(userId, order), HttpStatus.OK);
    }

    @GetMapping("products/followed/{userId}/list")
    public ResponseEntity<PostsByUserResponseDto> getFollowers(@PathVariable Integer userId,
                                                               @RequestParam(required = false) String order) {
        return new ResponseEntity<>(socialMeliService.searchPostsByUserIdInLastTwoWeeks(userId, order), HttpStatus.OK);
    }

//    punto 13
    @GetMapping("/users/followers/most-popular")
    public ResponseEntity<List<FollowerCountDTO>> getSellersByFollowerCount(){
        return new ResponseEntity<>(socialMeliService.getSellersByFollowerCount(), HttpStatus.OK);
    }


    @GetMapping("/products/promo-post/discount-range")
    public ResponseEntity<List<PostDto>> filterPostsByDiscountRange(@RequestParam Integer initialValue, @RequestParam Integer finalValue) {
        return new ResponseEntity<>(socialMeliService.filterPostsByDiscountRange(initialValue, finalValue), HttpStatus.OK);
    }

    @GetMapping("/products/{product}/price/{minPrice}/{maxPrice}")
    public ResponseEntity<List<ProductFilterDto>> getProductByRangePrice(@PathVariable Double minPrice,
                                                                         @PathVariable Double maxPrice,
                                                                         @PathVariable String product){
        return new ResponseEntity<>(socialMeliService.getProductByRangePrice(minPrice,maxPrice, product),HttpStatus.OK);
    }

}
