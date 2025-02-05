package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.controller;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.MessageDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PromoPostDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PostsBySellersFollowedDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response.PromosByUserCountDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.PostOrderTypeEnum;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IPostService postService;

    public ProductController(IPostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<MessageDto> createPost(@RequestBody PostDto post){
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.OK);
    }

    @PostMapping("/promo-post")
    public ResponseEntity<MessageDto> createPromoPost(@RequestBody PromoPostDto post){
        return new ResponseEntity<>(postService.createPromoPost(post), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostsBySellersFollowedDto> getPostsOfFollowedSeller(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "UNORDERED") String order
    ){
        return ResponseEntity.ok(postService.getPostsOfFollowedSeller(userId, PostOrderTypeEnum.valueOf(order.toUpperCase())));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<PromosByUserCountDto> getPromoPostCount(@RequestParam Integer user_id){
        return new ResponseEntity<>(postService.getPromoCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/promo-post/list")
    public ResponseEntity<List<PromoPostDto>> getPromoPostsBySellerId(@RequestParam Integer seller_id){
        return new ResponseEntity<>(postService.getPromoPostsBySellerId(seller_id), HttpStatus.OK);
    }

    // #------------------ CRUD METHODS: Reference to POSTS ~ Not products  ------------------#
    @GetMapping("")
    public ResponseEntity<List<PostDto>> getPosts() {
        return new ResponseEntity<>(postService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{postsId}")
    public ResponseEntity<PostDto> getPost(@PathVariable Integer postsId) {
        return new ResponseEntity<>(postService.findById(postsId), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<MessageDto> deletePost(@PathVariable Integer postId) {
        return new ResponseEntity<>(postService.delete(postId), HttpStatus.OK);
    }


}
