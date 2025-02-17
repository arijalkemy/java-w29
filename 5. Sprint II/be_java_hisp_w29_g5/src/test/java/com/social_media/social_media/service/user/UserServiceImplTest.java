package com.social_media.social_media.service.user;

import com.social_media.social_media.dto.response.FollowersResponseDto;
import com.social_media.social_media.entity.Follow;
import com.social_media.social_media.entity.User;
import com.social_media.social_media.exception.InvalidOrderException;
import com.social_media.social_media.exception.NotFoundException;
import com.social_media.social_media.repository.follow.FollowRepositoryImpl;
import com.social_media.social_media.repository.post.PostRepositoryImpl;
import com.social_media.social_media.repository.user.IUserRepository;
import com.social_media.social_media.repository.user.UserRepositoryImpl;
import com.social_media.social_media.utils.MessagesExceptions;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)


class UserServiceImplTest {


}