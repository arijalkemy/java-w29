package com.project.be_java_hisp_w29_g10.controller;

import com.project.be_java_hisp_w29_g10.dto.request.PostRequestDto;
import com.project.be_java_hisp_w29_g10.dto.response.PostResponseDto;
import com.project.be_java_hisp_w29_g10.dto.response.PromoPostCountDto;
import com.project.be_java_hisp_w29_g10.dto.response.PromoPostResponseDto;
import com.project.be_java_hisp_w29_g10.dto.response.RecentPostsResponseDto;
import com.project.be_java_hisp_w29_g10.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final IPostService postService;

    public ProductController(IPostService postService){
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<String> savePost(@RequestBody PostRequestDto postDto){
        postService.save(postDto);
        return new ResponseEntity<>("Publicación creada exitosamente.", HttpStatus.OK);
    }
    @DeleteMapping("/post/{post_id}")
    public ResponseEntity<String> deletePost(@PathVariable Long post_id){
        postService.delete(post_id);
        return ResponseEntity.ok("Publicación eliminada exitosamente.");
    }
    @PostMapping("/promo-post")
    public ResponseEntity<String> savePromoPost(@RequestBody PostRequestDto postRequestDto){
        postService.savePromo(postRequestDto);
        return new ResponseEntity<>("Publicación con promo creada exitosamente.", HttpStatus.OK);
    }
    @GetMapping("/promo-post/count")
    public ResponseEntity<PromoPostCountDto> getPromoPost(@RequestParam Long user_id){
        PromoPostCountDto countDto = postService.getPromoPostCountBySellerId(user_id);
        return new ResponseEntity<>(countDto, HttpStatus.OK);
    }
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getRecentPostsByFollowedSellers(@PathVariable Long userId, @RequestParam(required = false) String order) {
        RecentPostsResponseDto response = postService.getRecentPostsByFollowedSellers(userId);
        if (order != null){
            response = postService.OrderByDate(response,order);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @GetMapping("/seller/{sellerId}/list")
    public ResponseEntity<List<PromoPostResponseDto>> getPostsBySeller(@PathVariable Long sellerId, @RequestParam(required = false) Boolean hasPromo, @RequestParam(required = false) Integer category){
        return new ResponseEntity<>(postService.getPostsBySellerId(sellerId, hasPromo, category), HttpStatus.OK);
    }
}
