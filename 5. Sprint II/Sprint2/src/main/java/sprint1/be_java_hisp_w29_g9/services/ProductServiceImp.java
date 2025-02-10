package sprint1.be_java_hisp_w29_g9.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import sprint1.be_java_hisp_w29_g9.dtos.products.requests.CreateProductPostRequestDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.requests.CreatePromoProductPostRequestDTO;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.*;
import sprint1.be_java_hisp_w29_g9.entities.Post;
import sprint1.be_java_hisp_w29_g9.entities.Seller;
import sprint1.be_java_hisp_w29_g9.entities.User;
import sprint1.be_java_hisp_w29_g9.exceptions.BadRequestException;
import sprint1.be_java_hisp_w29_g9.exceptions.NotFoundException;
import sprint1.be_java_hisp_w29_g9.repositories.IUserSellerRepo;

@Service
@RequiredArgsConstructor
public class ProductServiceImp implements IProductService {
  private final IUserSellerRepo user_seller_repo;
  private final ObjectMapper objectMapper;
  private final MessageSource messageSourceBean;

  private Boolean isTypeOrderValid(String typeOrder){
    final List<String> typesOfOrdering = List.of("date_asc", "date_desc");
    if(typeOrder == null) return false;
    if(!typesOfOrdering.contains(typeOrder)){
        throw new BadRequestException(messageSourceBean.getMessage("type_of_order_not_exist", null, null));
    }
    return true;
  }

  @Override
  public ProductsFollowedDTO getPostsFollowedByDate(Integer userId, String order) {
    List<Seller> sellers = user_seller_repo.getUserFollowedById(userId);
    if(sellers.isEmpty()) throw new BadRequestException(messageSourceBean.getMessage("user_not_found_any_seller", null, null));
    List<PostDTO> postsDTO = sellers.stream()
      .flatMap(seller -> {
        List<Post> posts = seller.getPosts().stream()
          .filter(post -> LocalDate.parse(post.getDate()).isAfter(LocalDate.now().minusWeeks(2)))
          .toList();
        return posts.stream()
          .map(post -> new PostDTO(
            seller.getId(),
            post.getPost_id(),
            post.getDate(),
            new ProductDTO(
              post.getProduct().getProduct_id(), 
              post.getProduct().getProduct_name(), 
              post.getProduct().getType(), 
              post.getProduct().getBrand(), 
              post.getProduct().getColor(), 
              post.getProduct().getNotes()
            ),
            post.getCategory(),
            post.getPrice()
          ));
      })
      .toList();
    if(isTypeOrderValid(order)) {
      postsDTO = postsDTO.stream()
      .sorted((p1, p2) -> order.equals("date_asc") ? 
        p1.getDate().compareTo(p2.getDate()) :
        p2.getDate().compareTo(p1.getDate()))
      .toList();
    }
    return new ProductsFollowedDTO(
      userId,
      postsDTO
    );
  }

  @Override
  public Boolean addProductInPromo(CreatePromoProductPostRequestDTO productInPromo) {
    Optional<Seller> sellerOptional = user_seller_repo.getSellerById(productInPromo.getUser_id());
    if(sellerOptional.isEmpty()) throw new BadRequestException(messageSourceBean.getMessage("seller_not_found_any_seller", null, null));
    Post post = objectMapper.convertValue(productInPromo, Post.class);
    Seller seller_entity = sellerOptional.get();
    Optional<Integer> index_optional = seller_entity.getPosts().stream().map(Post::getPost_id).max(Integer::compare);
    if(index_optional.isEmpty()) post.setPost_id(1);
    else post.setPost_id(index_optional.get() + 1);
    return user_seller_repo.addSellerPost(seller_entity, post);
  }


  @Override
  public PromosCountDTO promoPublicationsCountByUser(Integer userId){
    Optional<Seller> seller = user_seller_repo.getSellerById(userId);
    if(seller.isEmpty()) {
      throw new NotFoundException(messageSourceBean.getMessage("seller_not_found", null, null));
    }
    List<Post> posts = seller.get().getPosts().stream().filter(Post::getHas_promo).toList();
    if(posts.isEmpty()) throw new NotFoundException(messageSourceBean.getMessage("not_promotions", null, null));
    return new PromosCountDTO(userId,seller.get().getUser_name(), posts.size());
  }

  @Override
  public void addNewPublication(CreateProductPostRequestDTO publicationDTO) {
    Post post = objectMapper.convertValue(publicationDTO, Post.class);
    Optional<Seller> seller = user_seller_repo.getSellerById(publicationDTO.getUser_id());
    if (seller.isEmpty()) throw new BadRequestException(messageSourceBean.getMessage("seller_not_found", null, null)); 
    Seller seller_entity = seller.get();
    Optional<Integer> index_optional = seller_entity.getPosts().stream().map(Post::getPost_id).max(Integer::compare);
    if(index_optional.isEmpty()) post.setPost_id(1);
    else post.setPost_id(index_optional.get() + 1);
    post.setHas_promo(false);
    post.setDiscount(0.0);
    user_seller_repo.addSellerPost(seller.get(), post);
  }

  @Override
  public List<PostDiscountDTO> promoDiscountCalculate(Double discount) {
    List<Seller> sellers = user_seller_repo.getAllSellers();
    List<PostDiscountDTO> postDiscountDTOList = sellers.stream()
            .flatMap(seller -> seller.getPosts().stream()
                    .filter(post -> post.getHas_promo()&&post.getDiscount()>=discount)
                    .map(post -> {
                      PostDiscountDTO postDTO = objectMapper.convertValue(post,PostDiscountDTO.class);
                      postDTO.setUser_id(seller.getId());
                      return postDTO;
                    })
            ).toList();

    if (postDiscountDTOList.isEmpty()){
      throw new NotFoundException(messageSourceBean.getMessage("not_discount_promotions", null, null));
    }
    return postDiscountDTOList;
  }

  @Override
  public List<PostDTO> getSellerPosts(Integer seller_id) {
    Optional<Seller> seller = user_seller_repo.getSellerById(seller_id);
    if(seller.isEmpty()) throw new NotFoundException(messageSourceBean.getMessage("seller_not_found", null, null));
    List<Post> posts = seller.get().getPosts();
    if(posts.isEmpty()) throw new NotFoundException(messageSourceBean.getMessage("not_posts", null, null));
    return posts.stream()
      .map(post -> new PostDTO(
        seller_id,
        post.getPost_id(),
        post.getDate(),
        new ProductDTO(
          post.getProduct().getProduct_id(), 
          post.getProduct().getProduct_name(), 
          post.getProduct().getType(), 
          post.getProduct().getBrand(), 
          post.getProduct().getColor(), 
          post.getProduct().getNotes()
        ),
        post.getCategory(),
        post.getPrice()
      ))
      .toList();
  }

}
