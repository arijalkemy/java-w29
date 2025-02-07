package com.app.service;

import com.app.dto.request.PostDTO;
import com.app.dto.response.PostListDTO;
import com.app.dto.response.PromoProductsCountDTO;
import com.app.exception.BadRequestException;
import com.app.model.Post;
import com.app.model.User;
import com.app.repository.IPostRepository;
import com.app.repository.IUserRepository;
import com.app.util.DateOrder;
import com.app.utils.PostUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private IPostRepository postRepository;

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private PostServiceImpl postService;

    private int userId;

    private List<Post> followedUsersPosts;

    private String ascDateOrderStr;
    private String descDateOrderStr;
    private DateOrder ascDateOrder;
    private DateOrder descDateOrder;

    private LocalDate twoWeeksFromNow;
    private List<Post> postsInLastTwoWeeks;
    private List<Post> postsOutsideLastTwoWeeks;

    @BeforeEach
    public void setUp() {
        userId = PostUtils.getUserId();
        int followedUserId = PostUtils.getFollowedUserId();
        followedUsersPosts = PostUtils.getFollowedUsersPosts();
        ascDateOrderStr = PostUtils.getAscOrderString();
        descDateOrderStr = PostUtils.getDescOrderString();
        ascDateOrder = PostUtils.getAscOrder();
        descDateOrder = PostUtils.getDescOrder();
        twoWeeksFromNow = PostUtils.getTwoWeeksFromNow();
        postsInLastTwoWeeks = PostUtils.getPostsInLastTwoWeeks();
        postsOutsideLastTwoWeeks = PostUtils.getPostsOutsideLastTwoWeeks();

        Mockito.lenient().when(userRepository.findById(userId)).thenReturn(PostUtils.getUserOpt());
        Mockito.lenient().when(userRepository.getFollowedUserIds(userId)).thenReturn(PostUtils.getFollowedUsersIds());
        Mockito.lenient().when(postRepository.findPostsByUserId(followedUserId)).thenReturn(followedUsersPosts);
        Mockito.lenient().when(postRepository.findProductById(1))
                .thenReturn(Optional.of(PostUtils.getProductById(1)));
        Mockito.lenient().when(postRepository.findProductById(2))
                .thenReturn(Optional.of(PostUtils.getProductById(2)));
    }

    @Test
    @DisplayName("T-0005 US-0009 - Happy path: The method returns when the date order is valid")
    public void shouldFinishWhenDateOrderIsValid() {
        when(postRepository.searchMostRecentPostsSortedBy(followedUsersPosts, descDateOrder, twoWeeksFromNow))
                .thenReturn(postsInLastTwoWeeks);

        assertDoesNotThrow(() -> postService.searchPostsFromFollowedUsers(userId, descDateOrderStr));
    }

    @Test
    @DisplayName("T-0005 US-0009 - Sad path: Invalid date order flag")
    public void shouldThrowExceptionWhenDateOrderFlagIsInvalid() {
        String badOrder = PostUtils.getBadOrderString();
        assertThrows(BadRequestException.class, () -> postService.searchPostsFromFollowedUsers(userId, badOrder));
    }

    @Test
    @DisplayName("T-0006 US-0009 - Verify ascending and descending order of posts")
    public void shouldSortFollowedUsersPostsByDateOrder() {
        // Ascending order
        List<Post> ascPosts = PostUtils.getAscPostsInLastTwoWeeks();

        when(postRepository.searchMostRecentPostsSortedBy(followedUsersPosts, ascDateOrder, twoWeeksFromNow))
                .thenReturn(ascPosts);

        PostListDTO resultAsc = postService.searchPostsFromFollowedUsers(userId, ascDateOrderStr);
        LocalDate firstPostDateAsc = LocalDate.parse(resultAsc.getPosts().get(0).getDate());
        LocalDate secondPostDateAsc = LocalDate.parse(resultAsc.getPosts().get(1).getDate());

        assertTrue((firstPostDateAsc.isBefore(secondPostDateAsc)));

        // Descending order
        List<Post> descPosts = postsInLastTwoWeeks;

        when(postRepository.searchMostRecentPostsSortedBy(followedUsersPosts, descDateOrder, twoWeeksFromNow))
                .thenReturn(descPosts);

        PostListDTO resultDesc = postService.searchPostsFromFollowedUsers(userId, descDateOrderStr);
        LocalDate firstPostDateDesc = LocalDate.parse(resultDesc.getPosts().get(0).getDate());
        LocalDate secondPostDateDesc = LocalDate.parse(resultDesc.getPosts().get(1).getDate());

        assertTrue((firstPostDateDesc.isAfter(secondPostDateDesc)));
    }

    @Test
    @DisplayName("T-0008 US-0006 - Verificar publicaciones dentro de las últimas dos semanas de un vendedor")
    public void shouldReturnOnlyPostsFromLastTwoWeeksOfSeller() {
        when(postRepository.searchMostRecentPostsSortedBy(followedUsersPosts, descDateOrder, twoWeeksFromNow))
                .thenReturn(postsInLastTwoWeeks);

        PostListDTO result = postService.searchPostsFromFollowedUsers(userId, descDateOrderStr);

        for (PostDTO postDTO : result.getPosts()) {
            LocalDate postDate = LocalDate.parse(postDTO.getDate());
            assertTrue(postDate.isAfter(twoWeeksFromNow.minusDays(1)) || postDate.isEqual(twoWeeksFromNow));
            assertTrue(postDate.isBefore(LocalDate.now()) || postDate.isEqual(LocalDate.now()));
        }

        for (Post post : postsOutsideLastTwoWeeks) {
            assertFalse(result.getPosts().stream()
                    .anyMatch(postDTO -> Objects.equals(postDTO.getPost_id(), post.getId())));
        }
    }

    @Test
    @DisplayName("T-0009 US-00011 Search Promo Products Count By UserId Happy Path")
    public void searchPromoProductsCountByUserId(){
        Integer userId = 3;
        User user = PostUtils.getPromoUser();

        List<Post> promoPosts = PostUtils.createPromoPosts().stream()
                .filter(Post::getHasPromo)
                .toList();

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));
        when(postRepository.findPromoProductsCountByUserId(userId)).thenReturn(promoPosts);

        PromoProductsCountDTO result = postService.searchPromoProductsCountByUserId(userId);

        assertEquals(result.getPromo_products_count(), promoPosts.size());
    }

    @Test
    @DisplayName("T-0009 US-00011 Search Promo Products Count By UserId Throw Bad Request Exception")
    public void searchPromoProductsCountByUserIdThrowBadRequestException(){
        Integer userId = 1;
        User user = new User(userId, "Juan", Boolean.TRUE, null, List.of(), List.of());

        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        assertThrows(BadRequestException.class, () -> postService.searchPromoProductsCountByUserId(userId));
    }
}
