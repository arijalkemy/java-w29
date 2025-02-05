package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/** DTO de Seller que incluye a los usuarios que le siguen.
 * **/
@Getter
public class FollowersDto extends UserDto {

    private List<UserDto> followers;

    public FollowersDto() {}

    public FollowersDto(Integer userId, String username, List<UserDto> followers) {
        super(userId, username);
        this.followers = followers;
    }

    public static FollowersDto from(User user, Function<Integer, UserDto> mapper) {
        List<UserDto> userDtos = user
                .getFollow()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
        return new FollowersDto(user.getUserId(), user.getUsername(), userDtos);
    }

}
