package com.bootcamp.be_java_hisp_w29_g3.service;

import com.bootcamp.be_java_hisp_w29_g3.dto.UserDTO;
import com.bootcamp.be_java_hisp_w29_g3.dto.request.BuyerFollowedSellersDto;
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
import com.bootcamp.be_java_hisp_w29_g3.util.MapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.bootcamp.be_java_hisp_w29_g3.util.MapperUtil.mapToPost;

@Service
@RequiredArgsConstructor
public class SocialMeliServiceImpl implements ISocialMeliService {
    private final IUserRepository userRepository;
    private final IPostRepository postRepository;

    @Override
    public FollowDto followSeller(Integer userId, Integer userIdToFollow) {
        //Verifico existencia de vendedor
        if(!userRepository.existsSellerById(userIdToFollow)){
            throw new NotFoundException("No existe el vendedor");
        }

        //Verifico existencia de comprador
        if(!userRepository.existsBuyerById(userId)){
            throw new NotFoundException("No existe el usuario");
        }

        //Verifico si ya se siguen
        if(userRepository.buyerAlreadyFollowsSeller(userId,userIdToFollow)){
            throw new BadRequestException("El usuario ya sigue al vendedor");
        }

        userRepository.followSeller(userId,userIdToFollow);
        return new FollowDto("Vendedor seguido correctamente");
    }

    @Override
    public UnfollowDto unfollowSeller(Integer userId, Integer userIdToUnfollow) {

        //Verifico existencia de vendedor
        if(!userRepository.existsSellerById(userIdToUnfollow)){
            throw new NotFoundException("No existe el vendedor");
        }

        //Verifico existencia de comprador
        if(!userRepository.existsBuyerById(userId)){
            throw new NotFoundException("No existe el usuario");
        }

        //Verifico si ya se siguen
        if(!userRepository.buyerAlreadyFollowsSeller(userId,userIdToUnfollow)){
            throw new BadRequestException("El usuario no sigue al vendedor");
        }

        userRepository.unfollowSeller(userId,userIdToUnfollow);
        return new UnfollowDto("El usuario ya no sigue al vendedor");
    }


    @Override
    public BuyerFollowedSellersDto getUserFollowSellers(Integer buyerId, String order) {
        Buyer buyer = userRepository.getBuyerById(buyerId);

        if (buyer == null) {
            throw new NotFoundException("No existe el usuario");
        }

        List<Seller> sellers = userRepository.getSellersFollowedByBuyer(buyerId);

        if (sellers.isEmpty()) {
            throw new NotFoundException("El usuario no sigue vendedores");
        }

        sellers = sortList(sellers, order, Seller::getName);

        List<SellerFollowDto> followedSellers = sellers.stream()
                .map(seller -> new SellerFollowDto(seller.getId(), seller.getName()))
                .collect(Collectors.toList());

        return new BuyerFollowedSellersDto(buyer.getId(), buyer.getName(), followedSellers);
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
            throw new NotFoundException("No existe el usuario");
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

    @Override
    public UserFollowersDTO getSellerFollowers(Integer sellerId, String order) {

        Seller seller = userRepository.getSellerById(sellerId);

        if (seller == null) {
            throw new NotFoundException("No existe el vendedor");
        }

        List<UserDTO> followers = userRepository.getFollowers(sellerId).stream()
                                                .map(buyer -> new UserDTO(buyer.getId(), buyer.getName()))
                                                .collect(Collectors.toList());

        followers = sortList(followers, order, UserDTO::getUserName);

        return new UserFollowersDTO(sellerId, seller.getName(),followers);
    }

    private <T> List<T> sortList(List<T> list, String order, Function<T, String> getField) {
        if (order == null || order.isEmpty()) {
            return list;
        }

        switch (order.toLowerCase()) {
            case "name_asc":
                return list.stream()
                           .sorted(Comparator.comparing(getField))
                           .collect(Collectors.toList());

            case "name_desc":
                return list.stream()
                           .sorted(Comparator.comparing(getField).reversed())
                           .collect(Collectors.toList());

            default:
                throw new BadRequestException("Orden no válido: " + order);
        }
    }

    @Override
    public PostsByUserResponseDto searchPostsByUserIdInLastTwoWeeks(Integer userId, String order) {
        if(!userRepository.existsBuyerById(userId))
            throw new NotFoundException("No existe el usuario");

        List<Seller> sellers = userRepository.getSellersFollowedByBuyer(userId);
        if(sellers.isEmpty())
            throw new NotFoundException("El usuario no sigue vendedores");

        LocalDate limitDate = LocalDate.now().minusWeeks(2);

        List<Post> posts = userRepository
                .findPostsFromSellerByUserIdWithLimitDate(userId, limitDate)
                .stream().sorted(getPostDateComparator(order))
                .toList();

        if(posts.isEmpty()) {
            throw new NotFoundException("No hay posts para mostrar");
        }
        List<PostByUserDto> postsDto = MapperUtil.mapToPostByUserResponseDto(posts, userId);
        return new PostsByUserResponseDto(userId, postsDto);
    }

    private Comparator<Post> getPostDateComparator(String order){
        if(order.equalsIgnoreCase("date_desc")) {
            return Comparator.comparing(Post::getDate).reversed();
        }
        return Comparator.comparing(Post::getDate);
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
                        Integer sellerId = seller.getId();
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
