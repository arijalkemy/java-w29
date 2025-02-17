package com.social_media.social_media.controller;

import com.social_media.social_media.dto.response.PostDetailResponseDto;
import com.social_media.social_media.dto.response.PromoProductsResponseDto;
import com.social_media.social_media.dto.response.SellersPostsByFollowerResponseDto;
import com.social_media.social_media.dto.request.PostRequestDto;
import com.social_media.social_media.dto.request.PostPromoRequestDto;
import com.social_media.social_media.dto.response.PostPromoResponseDto;
import com.social_media.social_media.dto.response.PostPromoEndDateResponseDto;
import com.social_media.social_media.dto.request.PostPromoEndDateRequestDto;
import com.social_media.social_media.service.post.IPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class PostController {
    private final IPostService postService;

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<SellersPostsByFollowerResponseDto> getFollowedRecentPosts(
            @PathVariable Long userId,
            @RequestParam(defaultValue = "date_desc") String order) {
        SellersPostsByFollowerResponseDto responseDto = postService.searchFollowedPostsFromLastTwoWeeks(userId, order);
        return ResponseEntity.status(HttpStatus.OK).body(responseDto);
    }

    @PostMapping("/post")
    public ResponseEntity<?> postNew(@Valid @RequestBody PostRequestDto postProductRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPost(postProductRequestDto));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<PostPromoResponseDto> postNewPromo(@Valid @RequestBody PostPromoRequestDto postPromoRequestDto) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.createPostPromo(postPromoRequestDto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoProductsResponseDto> postPromoCount(@RequestParam Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(postService.searchSellersWithPromoPosts(userId));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDetailResponseDto> getById(@PathVariable Long postId) {
        return new ResponseEntity<>(postService.searchById(postId), HttpStatus.OK);
    }

    @PostMapping("/promo-post-end-date")
    public ResponseEntity<PostPromoEndDateResponseDto> postNewPromoEndDate(
            @Valid @RequestBody PostPromoEndDateRequestDto postPromoEndDateRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(postService.createPostPromoEndDate(postPromoEndDateRequestDto));
    }
}