package com.thiagoschreck.local.melisocial.service;

import com.thiagoschreck.local.melisocial.dto.PostDTO;
import com.thiagoschreck.local.melisocial.dto.request.CreateProductDTO;
import com.thiagoschreck.local.melisocial.dto.response.PromoPostsResponseDTO;
import com.thiagoschreck.local.melisocial.entity.product.Post;
import com.thiagoschreck.local.melisocial.entity.product.Product;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import com.thiagoschreck.local.melisocial.exception.IdMustNotBeNullException;
import com.thiagoschreck.local.melisocial.exception.ProductAlreadyExistsException;
import com.thiagoschreck.local.melisocial.exception.SellerNotFoundException;
import com.thiagoschreck.local.melisocial.repository.IPostsRepository;
import com.thiagoschreck.local.melisocial.repository.IProductsRepository;
import com.thiagoschreck.local.melisocial.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements IProductsService {
	private final IProductsRepository productsRepository;
	private final IPostsRepository postsRepository;
	private final IUsersRepository usersRepository;

	@Autowired
	public ProductsServiceImpl(IProductsRepository productsRepository, IPostsRepository postsRepository,
		IUsersRepository usersRepository) {
		this.productsRepository = productsRepository;
		this.postsRepository = postsRepository;
		this.usersRepository = usersRepository;
	}

	@Override
	public PromoPostsResponseDTO getAllPromoPostsFromSeller(Integer sellerId) {
		if (sellerId == null) {
			throw new IdMustNotBeNullException();
		}
		final Seller seller = usersRepository.findSellerById(sellerId)
			.orElseThrow(() -> new SellerNotFoundException(sellerId));
		List<Post> promoPosts = Optional.ofNullable(postsRepository.getAllPromoPostsFromSeller(sellerId))
			.orElse(Collections.emptyList());
		return new PromoPostsResponseDTO(seller.getUserId(), seller.getUserName(),
			promoPosts.stream().map(this::map).toList());
	}

	@Override
	public CreateProductDTO save(CreateProductDTO productDto) {
		if (this.productsRepository.getById(productDto.id()) != null)
			throw new ProductAlreadyExistsException(productDto.id());
		Product product = this.mapToProduct(productDto);
		this.productsRepository.save(product);
		return productDto;
	}

	private PostDTO map(Post post) {
		if (post == null) {
			return null;
		}
		if (post.getProduct() == null) {
			return new PostDTO(post.getId(), post.getDate(), null, null, null, null, null, null, post.getCategory(),
				post.getPrice(), post.isOnPromotion(), post.getDiscount());
		}
		return new PostDTO(post.getId(), post.getDate(), post.getProduct().getId(), post.getProduct().getName(),
			post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(),
			post.getProduct().getNotes(), post.getCategory(), post.getPrice(), post.isOnPromotion(),
			post.getDiscount());
	}

	private Product mapToProduct(CreateProductDTO productDto) {
		return new Product(productDto.id(), productDto.name(), productDto.type(), productDto.brand(),
			productDto.color(), productDto.notes());
	}
}
