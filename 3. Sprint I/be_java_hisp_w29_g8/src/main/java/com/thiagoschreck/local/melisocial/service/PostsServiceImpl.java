package com.thiagoschreck.local.melisocial.service;

import com.thiagoschreck.local.melisocial.dto.request.CreatePostDTO;
import com.thiagoschreck.local.melisocial.dto.request.CreateProductDTO;
import com.thiagoschreck.local.melisocial.dto.response.FeedPostsDto;
import com.thiagoschreck.local.melisocial.dto.response.PostWithNoPromoAndDiscountDto;
import com.thiagoschreck.local.melisocial.dto.response.PromoPostsCountDTO;
import com.thiagoschreck.local.melisocial.entity.product.Post;
import com.thiagoschreck.local.melisocial.entity.product.Product;
import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import com.thiagoschreck.local.melisocial.entity.user.User;
import com.thiagoschreck.local.melisocial.exception.ClientNotFoundException;
import com.thiagoschreck.local.melisocial.exception.DiscountMustHaveValidValueException;
import com.thiagoschreck.local.melisocial.exception.HasDiscountMustBeTrueException;
import com.thiagoschreck.local.melisocial.exception.IdMustNotBeNullException;
import com.thiagoschreck.local.melisocial.exception.InvalidOrderValueException;
import com.thiagoschreck.local.melisocial.exception.SellerNotFoundException;
import com.thiagoschreck.local.melisocial.repository.IPostsRepository;
import com.thiagoschreck.local.melisocial.repository.IProductsRepository;
import com.thiagoschreck.local.melisocial.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@Service
public class PostsServiceImpl implements IPostsService {
    private final IProductsService productsService;
    private final IPostsRepository postsRepository;
    private final IUsersRepository usersRepository;
    private final IProductsRepository productsRepository;

    @Autowired
    public PostsServiceImpl(IProductsService productsService, IPostsRepository postsRepository,
                            IUsersRepository usersRepository, IProductsRepository productsRepository) {
        this.productsService = productsService;
        this.postsRepository = postsRepository;
        this.usersRepository = usersRepository;
        this.productsRepository = productsRepository;
    }

    @Override
    public CreatePostDTO saveWithoutDiscount(CreatePostDTO createPostDto) {
        CreateProductDTO productDto = createPostDto.productDto();
        if (usersRepository.findSellerById(createPostDto.userId()).isEmpty()) {
            throw new SellerNotFoundException(createPostDto.userId());
        }
        productsService.save(productDto);
        Product productSaved = productsRepository.getById(productDto.id());
        Post postToSave = mapToPost(createPostDto, productSaved, false, 0);
        postsRepository.save(postToSave);
        return createPostDto;
    }

    @Override
    public CreatePostDTO saveWithDiscount(CreatePostDTO createPostDto) {
        if (createPostDto.discount() <= 0.0 || createPostDto.discount() > 1.0) {
            throw new DiscountMustHaveValidValueException();
        }
        if (!createPostDto.hasPromo()) {
            throw new HasDiscountMustBeTrueException();
        }
        return savePost(createPostDto);
    }

    @Override
    public List<FeedPostsDto> searchPostsByFollowedSellersWithinWeeksAgoOrder(Integer userId, String order) {
        Client client = usersRepository.findClientById(userId)
                .orElseThrow(ClientNotFoundException::new);

        List<Seller> sellersFollowedByUser = client.getFollowing();
        LocalDate weeksAgo = LocalDate.now().minusWeeks(2);

		if(!"date_asc".equalsIgnoreCase(order) && !"date_desc".equalsIgnoreCase(order)) {
			throw new InvalidOrderValueException();
		}

		List<Post> posts = sellersFollowedByUser.stream()
				.map(User::getUserId)
				.flatMap(id -> postsRepository.getAllPostFromSellersWithinWeeksAgoOrderAsc(id, weeksAgo))
				.sorted(Comparator.comparing(Post::getDate).thenComparing(Post::getId))
				.toList();

        if (order.equalsIgnoreCase("date_desc")) {
            posts = posts.reversed();
        }

        List<PostWithNoPromoAndDiscountDto> postDtos = posts.stream()
                .map(this::mapPostToPostWithNoPromoAndDiscount)
                .toList();

        return List.of(new FeedPostsDto(userId, postDtos));
    }

    @Override
    public List<FeedPostsDto> searchPostsByFollowedSellersWithinWeeksAgo(Integer clientId) {
        Client client = usersRepository.findClientById(clientId)
                .orElseThrow(ClientNotFoundException::new);

        List<Seller> sellersFollowedByUser = client.getFollowing();
        LocalDate weeksAgo = LocalDate.now().minusWeeks(2);

        List<Post> postByFollowedSellersWithinTwoWeeks = sellersFollowedByUser.stream()
                .map(User::getUserId)
                .flatMap(id -> postsRepository.getAllPostFromSellersWithinWeeksAgo(id, weeksAgo).stream())
                .toList();

        List<PostWithNoPromoAndDiscountDto> postWithNoPromoAndDiscountDto = postByFollowedSellersWithinTwoWeeks.stream()
                .map(this::mapPostToPostWithNoPromoAndDiscount)
                .toList();

        return List.of(new FeedPostsDto(clientId, postWithNoPromoAndDiscountDto));
    }

    @Override
    public PromoPostsCountDTO getPromoPostsCountFromSeller(Integer sellerId) {
        if (sellerId == null) {
            throw new IdMustNotBeNullException();
        }
        final Seller seller = usersRepository.findSellerById(sellerId)
                .orElseThrow(() -> new SellerNotFoundException(sellerId));
        long postCount = postsRepository.getPromoPostsCountFromSeller(sellerId);
        return new PromoPostsCountDTO(seller.getUserId(), seller.getUserName(), postCount);
    }

    private CreatePostDTO savePost(CreatePostDTO createPostDto) {
        usersRepository.findSellerById(createPostDto.userId()).orElseThrow(
                () -> new SellerNotFoundException(createPostDto.userId()));
        CreateProductDTO productDto = createPostDto.productDto();

        productsService.save(productDto);
        Product productSaved = productsRepository.getById(productDto.id());

        Post postToSave = mapToPost(createPostDto, productSaved, createPostDto.hasPromo(), createPostDto.discount());
        postsRepository.save(postToSave);
        return createPostDto;
    }

    private Post mapToPost(CreatePostDTO createPostDto, Product productSaved, boolean hasPromo, double discount) {
        return new Post(postsRepository.getIdentity(),
                createPostDto.userId(),
                createPostDto.date(),
                productSaved,
                createPostDto.category(),
                createPostDto.price(),
                hasPromo,
                discount);
    }

    private PostWithNoPromoAndDiscountDto mapPostToPostWithNoPromoAndDiscount(Post post) {
        return new PostWithNoPromoAndDiscountDto(
                post.getUserId(),
                post.getId(),
                post.getDate(),
                post.getProduct().getId(),
                post.getProduct().getName(),
                post.getProduct().getType(),
                post.getProduct().getBrand(),
                post.getProduct().getColor(),
                post.getProduct().getNotes(),
                post.getCategory(),
                post.getPrice()
        );
    }

}