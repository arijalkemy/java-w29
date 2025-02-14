package com.meli.socialmeli.controller;


import com.meli.socialmeli.constants.Endpoints;
import com.meli.socialmeli.constants.OrderType;
import com.meli.socialmeli.dto.response.ResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meli.socialmeli.dto.NumberOfProductsInSaleDto;
import com.meli.socialmeli.dto.PostDto;
import com.meli.socialmeli.dto.response.PostFromFollowedDto;
import com.meli.socialmeli.dto.response.ProductsOfSellerDto;
import com.meli.socialmeli.dto.response.ResponseDto;
import com.meli.socialmeli.service.IPostService;
import com.meli.socialmeli.service.PostServiceImpl;

import java.util.List;

@RestController
@RequestMapping(Endpoints.BASE_POSTS)
public class PostController {

    private IPostService postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @PostMapping(Endpoints.POSTS_POST)
    public ResponseEntity<ResponseDto> addPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(postService.addPost(postDto), HttpStatus.CREATED);
    }

    @PostMapping(Endpoints.POSTS_PROMO_POST)
    public ResponseEntity<ResponseDto> createPromoPost(@Valid @RequestBody PostDto promoPostDto) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.addPromoPost(promoPostDto));
    }

    @GetMapping(Endpoints.POSTS_PROMO_POST_COUNT)
    public ResponseEntity<NumberOfProductsInSaleDto> getNumberOfProductsInSaleOfSeller(@RequestParam(name="user_id") Integer sellerId) {
        return new ResponseEntity<>(postService.getNumberOfProductsInSaleBySellerId(sellerId), HttpStatus.OK);
    }

    @GetMapping(Endpoints.POSTS_FOLLOWED_LIST)
    public ResponseEntity<PostFromFollowedDto> getPostsFromFollowedUsers(
            @PathVariable Integer userId,
            @RequestParam(required = false) String order
    ) {
        OrderType orderType = OrderType.fromString(order);
        return ResponseEntity.status(HttpStatus.OK).body(postService.getPostsFromFollowedUsers(userId, orderType.getValue()));
    }

    @GetMapping(Endpoints.POSTS_PROMO_LIST)
    public ResponseEntity<ProductsOfSellerDto> listAllProductsInSaleOfSeller(@RequestParam("user_id") Integer sellerId) {
        return new ResponseEntity<>(postService.getAllProductsInSaleBySellerId(sellerId), HttpStatus.OK);
    }

    @GetMapping(Endpoints.POSTS_FILTER_BY_PRICE)
    public ResponseEntity<List<PostDto>> filterPostsByPrice(@RequestParam(required = false) Double minPrice, @RequestParam(required = false) Double maxPrice) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.filterPostsByPrice(minPrice, maxPrice));
    }
}
