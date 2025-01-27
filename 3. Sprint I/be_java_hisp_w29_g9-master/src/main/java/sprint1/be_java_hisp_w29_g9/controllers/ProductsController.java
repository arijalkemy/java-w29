package sprint1.be_java_hisp_w29_g9.controllers;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import sprint1.be_java_hisp_w29_g9.dtos.products.requests.CreateProductPostRequestDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.requests.CreatePromoProductPostRequestDTO;
import sprint1.be_java_hisp_w29_g9.services.IProductService;

@RequiredArgsConstructor
@RestController
public class ProductsController {
  private final IProductService productService;

  @GetMapping("/products/followed/{userId}/list")
  public ResponseEntity<?> publicationsByUser(
    @PathVariable Integer userId,
    @RequestParam(required = false) String order
    // date_asc or date_desc
  ) {
      return new ResponseEntity<>(productService.getPostsFollowedByDate(userId, order), HttpStatus.OK);
  }

  @PostMapping("/products/promo-post")
  public ResponseEntity<?> newPromoPublication(@RequestBody CreatePromoProductPostRequestDTO publicationDTO){
        productService.addProductInPromo(publicationDTO);
        return ResponseEntity.ok().build();
    }


  @GetMapping("/products/promo-post/count")
  public ResponseEntity<?> promoPublicationsCountByUser(
    @RequestParam Integer user_id
  ){
      return new ResponseEntity<>(productService.promoPublicationsCountByUser(user_id), HttpStatus.OK);
  }

    @PostMapping("/products/post")
    public ResponseEntity<?> newPublication(@RequestBody CreateProductPostRequestDTO publicationDTO){
      productService.addNewPublication(publicationDTO);
      return ResponseEntity.ok().build();
    }
    @GetMapping("/products/promo-post/discount")
  public ResponseEntity<?> promoDiscount(@RequestParam Double discount){
    return new ResponseEntity<>(productService.promoDiscountCalculate(discount),HttpStatus.OK);
    }
}
