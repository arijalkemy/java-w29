package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;

public class UserMapper {

    public static UserDto userToDto (User u) {
        return new UserDto(u.getUserId(), u.getUsername());
    }
}
