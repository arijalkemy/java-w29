package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import lombok.Getter;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/** DTO de User que incluye a los vendedores que sigue.
 *  **/
@Getter
public class FollowingDto extends UserDto {
    private List<UserDto> following;

    public FollowingDto() {}

    public FollowingDto(Integer userId, String username, List<UserDto> following) {
        super(userId, username);
        this.following = following;
    }

    public static FollowingDto from(User user, Function<Integer, UserDto> mapper) {
        List<UserDto> userDtos = user
                .getFollow()
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
        return new FollowingDto(user.getUserId(), user.getUsername(), userDtos);
    }

}
