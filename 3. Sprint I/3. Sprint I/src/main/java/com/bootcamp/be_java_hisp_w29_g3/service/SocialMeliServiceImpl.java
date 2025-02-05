package com.bootcamp.be_java_hisp_w29_g3.service;

import com.bootcamp.be_java_hisp_w29_g3.dto.BuyerFollowedSellersDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.UserDTO;
import com.bootcamp.be_java_hisp_w29_g3.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.response.*;
import com.bootcamp.be_java_hisp_w29_g3.entity.Buyer;
import com.bootcamp.be_java_hisp_w29_g3.entity.Post;
import com.bootcamp.be_java_hisp_w29_g3.entity.Product;
import com.bootcamp.be_java_hisp_w29_g3.entity.Seller;
import com.bootcamp.be_java_hisp_w29_g3.exception.BadRequestException;
import com.bootcamp.be_java_hisp_w29_g3.exception.NotFoundException;
import com.bootcamp.be_java_hisp_w29_g3.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w29_g3.repository.IUserRepository;
import com.bootcamp.be_java_hisp_w29_g3.repository.UserRepositoryImpl;
import com.bootcamp.be_java_hisp_w29_g3.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.bootcamp.be_java_hisp_w29_g3.util.MapperUtil.mapToPost;

@Service
@RequiredArgsConstructor
public class SocialMeliServiceImpl implements ISocialMeliService {
    private final IUserRepository userRepository;
    private final IPostRepository postRepository;

    @Override
    public FollowDto followSeller(int userId, int userIdToFollow) {
        //Verifico existencia de vendedor
        if(userRepository.existsSellerById(userIdToFollow)){
            //Verifico existencia de comprador
            if(userRepository.existsBuyerById(userId)){
                //Verifico si ya se siguen
                if(!userRepository.buyerAlreadyFollowsSeller(userId,userIdToFollow)){
                    userRepository.followSeller(userId,userIdToFollow);
                    return new FollowDto("Vendedor seguido correctamente");
                }else{
                    throw new BadRequestException("El usuario ya sigue al vendedor");
                }

            }else{
                throw new BadRequestException("No existe el usuario");
            }

        }else{
            throw new BadRequestException("No existe el vendedor");
        }
    }

    @Override
    public UnfollowDto unfollowSeller(int userId, int userIdToUnfollow) {
        //Verifico existencia de vendedor
        if(userRepository.existsSellerById(userIdToUnfollow)){
            //Verifico existencia de comprador
            if(userRepository.existsBuyerById(userId)){
                //Verifico si ya se siguen
                if(userRepository.buyerAlreadyFollowsSeller(userId,userIdToUnfollow)){
                    userRepository.unfollowSeller(userId,userIdToUnfollow);
                    return new UnfollowDto("El usuario ya no sigue al vendedor");
                }else{
                    throw new BadRequestException("El usuario no sigue al vendedor");
                }

            }else{
                throw new BadRequestException("No existe el usuario");
            }

        }else{
            throw new BadRequestException("No existe el vendedor");
        }
    }

    @Override
    public BuyerFollowedSellersDto getUserFollowSellers(Integer buyerId, String order) {
        Buyer buyer = userRepository.getBuyerById(buyerId);
        if (buyer == null){
            throw new NotFoundException("No existe el usuario");
        }
        List<Seller> sellers = userRepository.getSellersFollowedByBuyer(buyerId, order);
        if (sellers.isEmpty()){
            throw new NotFoundException("El usuario no sigue vendedores");
        }
        List<SellerFollowDto> followedSellers = sellers.stream()
                .map(seller -> new SellerFollowDto(seller.getId(),seller.getName()))
                .collect(Collectors.toList());

        return new BuyerFollowedSellersDto(buyer.getId(),buyer.getName(),followedSellers);
    }

    @Override
    public PromoProductDto getPromoProducts(Integer userId) {
        Seller seller = userRepository.getSellerById(userId);
        if (seller == null){
            throw new NotFoundException("No existe el vendedor");
        }
        Long promoProducts = userRepository.countPromotionalProductsBySeller(userId);
        return new PromoProductDto(seller.getId(),seller.getName(),promoProducts);
    }


    @Override
    public FollowerCountDTO calculateSellerFollowerCount(Integer sellerId) {
        if (! userRepository.existsSellerById(sellerId)){
            throw new BadRequestException("No existe el vendedor");
        }
        return new FollowerCountDTO(sellerId,
                userRepository.getSellerById(sellerId).getName(),
                userRepository.getBuyersFollowingSeller(sellerId).stream().count());
    }

    @Override
    public List<FollowerCountDTO> getSellersByFollowerCount() {
        return userRepository.getAllSellersId().stream().map(id -> calculateSellerFollowerCount(id) )
                .sorted(Comparator.comparing(FollowerCountDTO::getFollowersCount).reversed()).toList();
    }

    @Override
    public PostResponseDto createPost(PostRequestDto post) {
        Integer postNewId = postRepository.findAll().size() + 1;
        Integer userId = post.getUserId();
        Post newPost = mapToPost(post);
        newPost.setId(postNewId);
        Post createdPost = userRepository.addPostToSeller(userId, newPost);
        postRepository.addPost(newPost);
        if (!newPost.getHasProm()) {
            return MapperUtil.mapToBasicPostResponseDto(createdPost);
        } else {
            return MapperUtil.mapToFullPostResponseDto(createdPost);
        }
    }

    public UserFollowersDTO getFollowers(int sellerId, String order) {
        if (!userRepository.existsSellerById(sellerId)) {
            throw new NotFoundException("No existe el vendedor");
        }
        List<UserDTO> followers = userRepository.getFollowers(sellerId, order).stream()
                                                .map(buyer -> new UserDTO(buyer.getId(), buyer.getName()))
                                                .collect(Collectors.toList());
        return new UserFollowersDTO(sellerId, followers);
    }

    @Override
    public PostsByUserResponseDto searchPostsByUserIdInLastTwoWeeks(Integer userId, String order) {
        List<Seller> sellers = userRepository.getSellersFollowedByBuyer(userId,null);
        if(sellers.isEmpty())
            throw new NotFoundException("El usuario no sigue vendedores");

        LocalDate limitDate = LocalDate.now().minusWeeks(2);

        List<Post> posts = userRepository.findPostsFromSellerByUserIdWithLimitDate(userId, limitDate, order);

        if(posts.isEmpty()) {
            throw new NotFoundException("No hay posts para mostrar");
        }
        List<PostByUserDto> postsDto = MapperUtil.mapToPostByUserResponseDto(posts, userId);
        return new PostsByUserResponseDto(userId, postsDto);
    }

    @Override
    public List<ProductFilterDto> getProductByRangePrice(Double minPrice, Double maxPrice, String product) {
        List<Seller> sellers = userRepository.getSellersByRangePrice(minPrice,maxPrice,product);

        if (sellers.isEmpty()){
            throw new NotFoundException("No se encontró el producto");
        }
        List<ProductFilterDto> result = new ArrayList<>();
        for (Seller seller : sellers) {
            for (Post post : seller.getPosts()) {
                if (post.getPrice() >= minPrice && post.getPrice() <= maxPrice) {
                    if (Objects.equals(post.getProduct().getName(), product)) {
                        int sellerId = seller.getId();
                        String sellerName = seller.getName();
                        Product prod = post.getProduct();
                        Double price = post.getPrice();
                        result.add(new ProductFilterDto(sellerId, sellerName, prod, price));
                    }
                }
            }
        }

        return result;
    }

    @Override
    public List<PostDto> filterPostsByDiscountRange(Integer initialValue, Integer finalValue) {
        List<Post> listPosts = postRepository.filterPostsByDiscountRange(initialValue,finalValue);
        if(listPosts.isEmpty()){
            throw new NotFoundException("No se encontraron posts con el rango indicado.");
        }
        return MapperUtil.buildPostDto(listPosts);
    }
}
