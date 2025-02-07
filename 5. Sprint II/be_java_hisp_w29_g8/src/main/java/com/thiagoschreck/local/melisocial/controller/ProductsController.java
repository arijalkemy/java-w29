package com.thiagoschreck.local.melisocial.controller;

import com.thiagoschreck.local.melisocial.dto.response.FeedPostsDto;

import com.thiagoschreck.local.melisocial.dto.request.CreatePostDTO;
import com.thiagoschreck.local.melisocial.dto.response.PromoPostsCountDTO;
import com.thiagoschreck.local.melisocial.dto.response.PromoPostsResponseDTO;
import com.thiagoschreck.local.melisocial.service.IPostsService;
import com.thiagoschreck.local.melisocial.service.IProductsService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
	private final IProductsService productsService;
	private final IPostsService postsService;

	@Autowired
	public ProductsController(IProductsService productsService, IPostsService postsService) {
		this.productsService = productsService;
		this.postsService = postsService;
	}

	@PostMapping("/post")
	public ResponseEntity<CreatePostDTO> create(@Valid @RequestBody CreatePostDTO createPostDto) {
		return ResponseEntity.ok(postsService.saveWithoutDiscount(createPostDto));
	}

	@PostMapping("/promo-post")
	public ResponseEntity<CreatePostDTO> createDiscountedPost(@Valid @RequestBody CreatePostDTO createPostDto){
		return ResponseEntity.ok(postsService.saveWithDiscount(createPostDto));
	}

	@GetMapping("/promo-post/count")
	public ResponseEntity<PromoPostsCountDTO> getCountProductsWithDiscount(@RequestParam("user_id") Integer user_id) {
		return ResponseEntity.ok(postsService.getPromoPostsCountFromSeller(user_id));
	}

	@GetMapping("/promo-post/list")
	public ResponseEntity<PromoPostsResponseDTO> getAllPromoPostsFromSeller(@PathParam("user_id") Integer user_id) {
		return ResponseEntity.ok(productsService.getAllPromoPostsFromSeller(user_id));
	}

	@GetMapping("/followed/{userId}/list")
	public ResponseEntity<List<FeedPostsDto>> getAllPostsByFollowedSellerWithinTwoWeeksOrder( @PathVariable Integer userId, @RequestParam(defaultValue = "date_asc") String order) {
		return ResponseEntity.ok(postsService.searchPostsByFollowedSellersWithinWeeksAgoOrder(userId, order));
	}

    public ResponseEntity<List<FeedPostsDto>> getAllPostsByFollowedSellerWithinTwoWeeks(@PathVariable Integer userId) {
        return ResponseEntity.ok(postsService.searchPostsByFollowedSellersWithinWeeksAgo(userId));
    }

}
