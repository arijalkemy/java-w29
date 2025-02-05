package com.project.be_java_hisp_w29_g10.service;

import com.project.be_java_hisp_w29_g10.dto.request.PostRequestDto;
import com.project.be_java_hisp_w29_g10.dto.request.ProductRequestDto;
import com.project.be_java_hisp_w29_g10.dto.response.*;
import com.project.be_java_hisp_w29_g10.entity.Post;
import com.project.be_java_hisp_w29_g10.entity.Product;
import com.project.be_java_hisp_w29_g10.entity.Seller;
import com.project.be_java_hisp_w29_g10.exception.BadRequestException;
import com.project.be_java_hisp_w29_g10.exception.ConflictException;
import com.project.be_java_hisp_w29_g10.exception.NotFoundException;
import com.project.be_java_hisp_w29_g10.repository.IPostRepository;
import com.project.be_java_hisp_w29_g10.repository.IProductRepository;
import com.project.be_java_hisp_w29_g10.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements IPostService{

    private final IPostRepository postRepository;
    private final ISellerService sellerService;
    private final IUserRepository userRepository;
    private final IFollowService followService;
    private final IProductRepository productRepository;



    public PostServiceImpl(IPostRepository postRepository, ISellerService sellerService, IUserRepository userRepository, IFollowService followService, IProductRepository productRepository) {
        this.postRepository = postRepository;
        this.sellerService = sellerService;
        this.userRepository = userRepository;
        this.followService = followService;
        this.productRepository = productRepository;
    }

    @Override
    public Post save(PostRequestDto postDto) {
        Optional<Seller> seller = sellerService.getSellerById(postDto.getUser_id());
        if(seller.isEmpty()) {
            throw new NotFoundException("Vendedor con la id: " + postDto.getUser_id() + " no encontrado");
        }
        Random random = new Random();
        long postId;
        Optional<Post> existPost;
        Post newPost;
        Product newProduct = convertToProduct(postDto.getProduct());

        do {
            postId = random.nextLong(1000);
            existPost = postRepository.getById(postId);
        } while (existPost.isPresent());

        newPost = convertToPost(postDto, postId);
        if(productRepository.getById(postDto.getProduct().getProduct_id())!=null) {
            throw new ConflictException("El producto con id: " + postDto.getProduct().getProduct_id() + " ya existe");
        }
        productRepository.save(newProduct);

        return postRepository.save(newPost);
    }

    @Override
    public Boolean delete(Long post_id) {
        Optional<Post> post = postRepository.getById(post_id);
        if (post.isEmpty()){
            throw new NotFoundException("El post con id: "+post_id+" no existe.");
        }
        Product product = productRepository.getById(post.get().getProduct_id());
        if (product == null){
            throw new NotFoundException("Error al buscar el producto asociado.");
        }

        productRepository.delete(product);
        return  postRepository.delete(post.get());
    }

    @Override
    public Post savePromo(PostRequestDto postRequestDto) {
        if (!postRequestDto.getHas_promo()){
            throw new BadRequestException("La publicación no tiene promo");
        }
        return save(postRequestDto);
    }

    @Override
    public List<PromoPostResponseDto> getPostsBySellerId(Long sellerId, Boolean hasPromo, Integer category) {
        Optional<Seller> seller = sellerService.getSellerById(sellerId);
        if (seller.isEmpty()) {
            throw new NotFoundException("Vendedor con la id: " + sellerId + " no encontrado");
        }

        List<Post> posts = postRepository.getAll(sellerId, hasPromo, category);

        return posts.stream().map(post -> new PromoPostResponseDto(
                post.getUser_id(),
                post.getPost_id(),
                post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                convertToProductResponse(post.getProduct_id()),
                post.getCategory(),
                post.getPrice(),
                post.getHas_promo(),
                post.getDiscount()
        )).collect(Collectors.toList());
    }

    @Override
    public PromoPostCountDto getPromoPostCountBySellerId(Long userId) {
        Optional<Seller> seller = sellerService.getSellerById(userId);
        if (seller.isEmpty()) {
            throw new NotFoundException("Vendedor con la id: " + userId+ " no encontrado");
        }
        List<Post> posts = postRepository.getPromoPostBySellerID(userId);
        PromoPostCountDto promoPostCountDto = new PromoPostCountDto();
        promoPostCountDto.setUser_id(userId);
        promoPostCountDto.setUser_name(seller.get().getUser_name());
        promoPostCountDto.setPromo_products_count((long) posts.size());
        return promoPostCountDto;
    }

    public Product convertToProduct(ProductRequestDto dto){
        return Product.builder()
                .product_id(dto.getProduct_id())
                .product_name(dto.getProduct_name())
                .type(dto.getType())
                .brand(dto.getBrand())
                .color(dto.getColor())
                .notes(dto.getNotes())
                .build();
    }

    public Post convertToPost(PostRequestDto dto, Long postId){
        return Post.builder()
                .post_id(postId)
                .user_id(dto.getUser_id())
                .date(dto.getDate())
                .product_id(dto.getProduct().getProduct_id())
                .category(dto.getCategory())
                .price(dto.getPrice())
                .has_promo(dto.getHas_promo())
                .discount(dto.getDiscount())
                .build();

    }

    @Override
    public RecentPostsResponseDto getRecentPostsByFollowedSellers(Long userId) {
        // Verificar si el usuario existe
        if (userRepository.findById(userId).isEmpty()) {
            throw new NotFoundException("Usuario con ID " + userId + " no encontrado.");
        }

        // Obtener vendedores que sigue el usuario
        List<Long> followedSellers = followService.getSellersFollowedByUser(userId);

        // Obtener publicaciones recientes
        LocalDate twoWeeksAgo = LocalDate.now().minusWeeks(2);
        List<PostResponseDto> recentPosts = followedSellers.stream()
                .flatMap(sellerId -> postRepository.getPostsBySellerID(sellerId).stream())
                .filter(post -> post.getDate().isAfter(twoWeeksAgo))
                .sorted(Comparator.comparing(Post::getDate).reversed())
                .map(post -> new PostResponseDto(
                        post.getUser_id(),
                        post.getPost_id(),
                        post.getDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), // Ajuste de formato de fecha
                        convertToProductResponse(post.getProduct_id()),
                        post.getCategory(),
                        post.getPrice()
                ))
                .collect(Collectors.toList());

        // Devolver la respuesta en el formato esperado
        return new RecentPostsResponseDto(userId, recentPosts);
    }

    @Override
    public RecentPostsResponseDto OrderByDate(RecentPostsResponseDto recentPostsResponse, String order) {
        List<PostResponseDto> posts = new ArrayList<>(recentPostsResponse.getPosts());
        if (order.equals("date_asc")) {
            posts.sort(Comparator.comparing(PostResponseDto::getDate));
        } else if (order.equals("date_desc")) {
            posts.sort(Comparator.comparing(PostResponseDto::getDate).reversed());
        }else {
            throw new NotFoundException("No se encontro el tipo de ordenamiento especificado");
        }

        recentPostsResponse.setPosts(posts);
        return recentPostsResponse;
    }

    private ProductResponseDto convertToProductResponse(Long productId) {
        Product product = productRepository.getById(productId);
        return new ProductResponseDto(
                product.getProduct_id(),
                product.getProduct_name(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }
}
