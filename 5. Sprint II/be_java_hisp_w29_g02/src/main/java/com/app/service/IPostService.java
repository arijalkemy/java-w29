package com.app.service;

import com.app.dto.request.PostDTO;
import com.app.dto.request.ProductDTO;
import com.app.dto.response.PostListDTO;
import com.app.dto.response.PromoPostUserDTO;
import com.app.dto.response.PromoProductsCountDTO;
import com.app.dto.response.SuccessDTO;
import com.app.exception.BadRequestException;
import com.app.exception.EntityNotFoundException;

import java.time.LocalDate;
import java.util.List;

public interface IPostService {
    /**
     * Provides the user id, username and promo products count of the respective user.
     *
     * @param userId the user's id.
     * @return a PromoProductsCountDTO.
     * @throws EntityNotFoundException if the user is not found.
     */
    PromoProductsCountDTO searchPromoProductsCountByUserId(Integer userId);

    /**
     * If the provided user exists and is a seller, it provides some of the user data and a
     * List<PostsWithProductDTO> for their posts.
     *
     * @param userId the user's id.
     * @return a PromoPostUserDTO.
     * @throws EntityNotFoundException if the user is not found, has no promo posts, or a post's product is not found.
     * @throws BadRequestException if the user is not a seller.
     */
    PromoPostUserDTO searchListPromoProductsSinceDate(Integer userId, LocalDate since);

    /**
     * It searches for the post's user and checks whether they are a seller or not. If they aren't, now they are
     * (their isSeller attribute is set to true). The received PostDTO product is created and added into the
     * products DB. After that, the post object is created and stored into the posts DB.
     * Its id is added to the user's post ids list.
     *
     * @param postDTO the post to be created.
     * @return a SuccessDTO.
     * @throws EntityNotFoundException if the post's user is not found.
     */
    SuccessDTO createPost(PostDTO postDTO);

    /**
     * It creates a new post only if it has a promo.
     *
     * @param postRequest the post to be created.
     * @return a SuccessDTO.
     * @throws BadRequestException if the post does not have a promo or the discount is not positive.
     */
    SuccessDTO addPromoPost(PostDTO postRequest);

    /**
     * Provides the user's followed list posts that were published two weeks ago at max. Depending on the dateOrder,
     * this list can be sorted by date ascending or date descending order.
     *
     * @param userId the user's id.
     * @param dateOrder the post's date order.
     * @return a PostListDTO.
     * @throws BadRequestException if no followed user has published a post in the last fourteen days.
     * @throws EntityNotFoundException if the user with the userId passed as a parameter does not exist, or if
     * the followed users list is empty.
     */
    PostListDTO searchPostsFromFollowedUsers(int userId, String dateOrder);

    /**
     * Retrieves all the posts.
     *
     * @return a PostDTO list.
     */
    List<PostDTO> searchAll();

    /**
     * Retrieves all the products.
     *
     * @return a ProductDTO list.
     */
    List<ProductDTO> searchAllProducts();
}
