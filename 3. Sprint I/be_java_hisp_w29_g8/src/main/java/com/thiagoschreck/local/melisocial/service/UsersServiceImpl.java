package com.thiagoschreck.local.melisocial.service;

import com.thiagoschreck.local.melisocial.entity.user.Client;
import com.thiagoschreck.local.melisocial.dto.request.CreateUserRequestDTO;
import com.thiagoschreck.local.melisocial.dto.response.CreateUserResponseDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.ClientDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.SellerFollowersCountDTO;
import com.thiagoschreck.local.melisocial.dto.response.user.UserInfoDTO;
import com.thiagoschreck.local.melisocial.entity.user.Seller;
import com.thiagoschreck.local.melisocial.entity.user.User;
import com.thiagoschreck.local.melisocial.exception.SellerNotFoundException;
import com.thiagoschreck.local.melisocial.exception.ClientNotFoundException;
import com.thiagoschreck.local.melisocial.exception.MissingUsernameException;
import com.thiagoschreck.local.melisocial.exception.UserNotFollowingSellerException;

import com.thiagoschreck.local.melisocial.exception.*;

import com.thiagoschreck.local.melisocial.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements IUsersService {
	private final IUsersRepository usersRepository;

    @Autowired
    public UsersServiceImpl(IUsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public SellerDTO getSellerFollowersByUserId(int userId, String order) {
        if (!"name_asc".equals(order) && !"name_desc".equals(order)) {
            throw new InvalidSortOrderException();
        }
        Seller seller = usersRepository.findSellerById(userId, order).orElseThrow(() -> new SellerNotFoundException(userId));
        return map(seller);
    }

    @Override
    public ClientDTO getClientFollowedSellersByUserId(int userId, String order) {
        if (!"name_asc".equals(order) && !"name_desc".equals(order)) {
            throw new InvalidSortOrderException();
        }
        Client client = usersRepository.findClientById(userId, order).orElseThrow(() -> new ClientNotFoundException(userId));
        return map(client);
    }

    private SellerDTO map(Seller seller) {
        List<UserInfoDTO> followers = seller.getFollowers().stream()
                .map(this::mapUserInfo)
                .toList();

        return new SellerDTO(
                seller.getUserId(),
                seller.getUserName(),
                followers
        );
    }

    private UserInfoDTO mapUserInfo(User user) {
        return new UserInfoDTO(
                user.getUserId(),
                user.getUserName()
        );
    }

    @Override
    public ClientDTO unfollowSeller(Integer userId, Integer userIdToUnfollow) {
        Client client = usersRepository.findClientById(userId).orElseThrow(ClientNotFoundException::new);
        Seller seller = usersRepository.findSellerById(userIdToUnfollow).orElseThrow(() -> new SellerNotFoundException(userId));
        client.getFollowing().stream()
                .filter(s -> s.getUserId().equals(userIdToUnfollow))
                .findFirst()
                .orElseThrow(() -> new UserNotFollowingSellerException(userId, userIdToUnfollow));

        client.getFollowing().removeIf(s -> s.getUserId().equals(userIdToUnfollow));
        seller.getFollowers().removeIf(c -> c.getUserId().equals(userId));

        return map(client);
    }

    @Override
    public CreateUserResponseDTO createClient(CreateUserRequestDTO request) {
        validateUsername(request);
        return mapUser(usersRepository.save(new Client(formatUsername(request.userName()))));
    }

    @Override
    public CreateUserResponseDTO createSeller(CreateUserRequestDTO request) {
        validateUsername(request);
        return mapUser(usersRepository.save(new Seller(formatUsername(request.userName()))));
    }

    private void validateUsername(CreateUserRequestDTO request) {
        if (request.userName() == null || request.userName().isBlank()) {
            throw new MissingUsernameException();
        }
    }

    private String formatUsername(String username) {
        return username.trim().replace(" ", "_");
    }

    @Override
    public ClientDTO followSeller(Integer userId, Integer userIdToFollow) {
        Client client = usersRepository.findClientById(userId).orElseThrow(ClientNotFoundException::new);
        Seller seller = usersRepository.findSellerById(userIdToFollow).orElseThrow(() -> new SellerNotFoundException(userIdToFollow));
        client.getFollowing().stream()
                .filter(s -> s.getUserId().equals(userIdToFollow))
                .findAny()
                .ifPresent(_ -> {
                    throw new UserAlreadyFollowingSellerException(userId, userIdToFollow);
                });

        client.getFollowing().add(seller);
        seller.getFollowers().add(client);
        return map(client);
    }

    @Override
    public SellerFollowersCountDTO getSellerFollowersCount(int userId) {
        Seller seller = usersRepository.findSellerById(userId).orElseThrow(() -> new SellerNotFoundException(userId));
        return mapSellerFollowersCountDTO(seller);
    }

    private SellerFollowersCountDTO mapSellerFollowersCountDTO(Seller seller) {
        return new SellerFollowersCountDTO(
                seller.getUserId(),
                seller.getUserName(),
                seller.getFollowers().size()
        );
    }

    private ClientDTO map(Client client) {
        List<UserInfoDTO> followingDTOs = client.getFollowing()
                .stream()
                .map(s -> new UserInfoDTO(s.getUserId(), s.getUserName()))
                .toList();
        return new ClientDTO(client.getUserId(), client.getUserName(), followingDTOs);
    }

    private CreateUserResponseDTO mapUser(User user) {
        return new CreateUserResponseDTO(user.getUserId(), user.getUserName());
    }

}
