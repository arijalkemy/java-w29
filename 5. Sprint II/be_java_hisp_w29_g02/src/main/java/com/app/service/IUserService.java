package com.app.service;

import com.app.dto.response.*;
import com.app.exception.BadRequestException;
import com.app.exception.EntityNotFoundException;
import com.app.exception.ForbiddenException;

import java.util.List;

public interface IUserService {
    /**
     * Finds the User object by id and adds the seller id provided by parameter into their following list.
     * The main user id is also added into the seller's followers list.
     *
     * @param userId the user's id.
     * @param userIdToFollow the id from the user to be followed.
     * @return a SuccessDTO.
     * @throws BadRequestException if both users are the same, or if the user to be followed is not a seller.
     * @throws EntityNotFoundException if one of the users is not found.
     */
    SuccessDTO followUser(int userId, int userIdToFollow);

    /**
     * It searches a user's following list. After doing so, it sorts the list by name alphabetically, or reversed
     * (depending on the provided order).
     *
     * @param userId the user's id.
     * @param order the name order of the returned users.
     * @return a FollowedListDTO.
     * @throws EntityNotFoundException if the user is not found.
     */
    FollowedListDTO searchFollowedList(int userId, String order);

    /**
     * Finds the user by id, and then it searches for the amount of followers they have.
     *
     * @param userId the user's id.
     * @return a FollowersCountDTO.
     * @throws BadRequestException if the user is not a seller.
     * @throws EntityNotFoundException if no user with that id was found.
     */
    FollowersCountDTO searchFollowersCount(int userId);

    /**
     * Gets both users by id and deletes the link between them. Meaning that the first user is removed from the
     * second's followers list, and the second one is removed from the first's followed list.
     *
     * @param userId the user's id.
     * @param userIdToUnfollow the id from the user to be unfollowed.
     * @return a SuccessDTO.
     * @throws BadRequestException if the user tries to unfollow themselves.
     * @throws EntityNotFoundException if no user was found, or the link between both users was not found.
     * @throws ForbiddenException if the user is not a seller.
     */
    SuccessDTO deleteFollowedSeller(int userId, int userIdToUnfollow);

    /**
     * It searches a user's followers list. After doing so, it sorts the list by name alphabetically, or reversed
     * (depending on the provided order).
     *
     * @param userId the user's id.
     * @param order the name order of the returned users.
     * @return a FollowerListDTO.
     * @throws EntityNotFoundException if the user is not found or is not a seller.
     */
    FollowerListDTO searchFollowerList(int userId, String order);

    /**
     * Retrieves all the users.
     *
     * @return a UserDTO list.
     */
    List<UserDTO> searchAll();
}
