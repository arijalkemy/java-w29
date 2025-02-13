package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.CommonUser;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;

public class UserMapper {

    public static UserDto userToDto (User u) {
        return new UserDto(u.getUserId(), u.getUsername());
    }

    public static CommonUser dtoToUser (UserDto u) {
        CommonUser user = new CommonUser(u.getUserName());
        user.setUserId(u.getUserId());
        return user;
    }
}
