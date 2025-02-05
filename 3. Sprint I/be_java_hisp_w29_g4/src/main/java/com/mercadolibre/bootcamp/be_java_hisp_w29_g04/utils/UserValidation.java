package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.UserTypeEnum;

public class UserValidation {

    public static boolean isSeller(User user) {
        return user.getType() == UserTypeEnum.SELLER;
    }

    public static boolean isCommonUser(User user) {
        return user.getType() == UserTypeEnum.COMMON;
    }

}