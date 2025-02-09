package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;

public interface IUserValidation {
    boolean isSeller(User user);
    boolean isCommonUser(User user);
}