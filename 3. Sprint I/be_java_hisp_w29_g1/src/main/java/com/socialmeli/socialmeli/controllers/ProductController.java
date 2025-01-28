package com.socialmeli.socialmeli.controllers;
import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.response.PostIdDto;
import com.socialmeli.socialmeli.dto.response.ProductListDto;
import com.socialmeli.socialmeli.dto.response.ProductSaleCountDto;
import com.socialmeli.socialmeli.dto.request.CommentRequestDto;
import com.socialmeli.socialmeli.dto.response.*;
import com.socialmeli.socialmeli.services.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final IPostService postService;

    // US 0005 - Dar de alta una nueva publicación.
    @PostMapping("/post")
    public ResponseEntity<MessageDto> addPost(@RequestBody PostDto postDto) {
        return ResponseEntity.ok(postService.savePost(postDto));
    }

    // US 0006 - Obtener un listado de las publicaciones realizadas en las últimas dos semanas,
    // por los vendedores que un usuario sigue
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<ProductListDto> getPostsOfFollowedSellers(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "date_desc") String order) {
        return ResponseEntity.ok(postService.getRecentPostFromUsers(order,userId));
    }

    // US 0010 - Llevar a cabo la publicación de un nuevo producto en promoción.
    @PostMapping("/promo-post")
    public ResponseEntity<MessageDto> addPostSale(@RequestBody PostSaleDto postSaleDto){
        return ResponseEntity.ok(postService.savePostSale(postSaleDto));
    }

    // US 0011 - Obtener la cantidad de productos en promoción de un determinado vendedor.
    @GetMapping("promo-post/count")
    public ResponseEntity<ProductSaleCountDto> getPromoPostCount(@RequestParam("user_id") Integer userId) {
        return ResponseEntity.ok(postService.getProductSaleCountByUser(userId));
    }

    // US 0012 - Obtener un listado de todos los productos en promoción con la opción de filtrar por un vendedor.
    @GetMapping("promo-post/list")
    public ResponseEntity<List<ProductsPromotionDto>> getPromoPostList(@RequestParam(value = "user_id", required = false) Integer userId) {
        return ResponseEntity.ok(postService.getProductSaleCount(userId));
    }

    // US 0013 - Agregar comentario a una publicación determinada.
    @PostMapping("/comments/{postId}")
    public ResponseEntity<MessageDto> addCommentToPost(
            @PathVariable Integer postId,
            @RequestBody CommentRequestDto commentDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.addComment(postId, commentDto));
    }

    // US 0014 - Obtener un listado de los comentarios de una publicación.
    @GetMapping("/comments/{postId}")
    public ResponseEntity<CommentsListDto> getComments(@PathVariable Integer postId) {
        return ResponseEntity.ok(postService.getCommentsById(postId));
    }

    // US 0015 - Obtener un listado de publicaciones filtradas.
    @GetMapping("/filter")
    public ResponseEntity<List<PostIdDto>> getFilteredPosts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false, value = "price_range") String priceRange,
            @RequestParam(required = false, value = "product_brand") String productBrand,
            @RequestParam(required = false, value = "product_type") String productType) {
        return ResponseEntity.ok(postService.getFilteredPosts(category, priceRange,productBrand, productType));
    }
}
