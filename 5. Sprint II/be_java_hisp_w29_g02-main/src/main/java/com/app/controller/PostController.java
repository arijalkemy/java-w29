package com.app.controller;

import com.app.dto.request.PostDTO;
import com.app.dto.request.ProductDTO;
import com.app.dto.response.PostListDTO;
import com.app.dto.response.PromoPostUserDTO;
import com.app.dto.response.PromoProductsCountDTO;
import com.app.dto.response.SuccessDTO;
import com.app.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class PostController {

    private final IPostService postService;

    @GetMapping("/posts/all")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return new ResponseEntity<>(postService.searchAll(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return new ResponseEntity<>(postService.searchAllProducts(), HttpStatus.OK);
    }

    // US 0005
    @PostMapping("/post")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDTO postDTO) {
        return new ResponseEntity<>(postService.createPost(postDTO), HttpStatus.CREATED);
    }

    // US 0006 & US 0009
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostListDTO> getPostsFromFollowedUsers(
            @PathVariable int userId,
            @RequestParam(value = "order", required = false) String dateOrder
    ) {
        return new ResponseEntity<>(postService.searchPostsFromFollowedUsers(userId, dateOrder), HttpStatus.OK);
    }

    // US 0010
    @PostMapping("/promo-post")
    public ResponseEntity<SuccessDTO> postPromoPost(@RequestBody PostDTO postRequest) {
        return ResponseEntity.ok(postService.addPromoPost(postRequest));
    }

    // US 0011
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsCountDTO> getPromoProductsCountByUserId(@RequestParam("user_id") Integer userId) {
        return new ResponseEntity<>(postService.searchPromoProductsCountByUserId(userId), HttpStatus.OK);
    }

    // US 0012
    @GetMapping("/promo-post/list")
    public ResponseEntity<PromoPostUserDTO> getListPromoProductsSinceDate(
            @RequestParam Integer userId,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate date) {
        return new ResponseEntity<>(postService.searchListPromoProductsSinceDate(userId, date), HttpStatus.OK);
    }
}
