package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.utils;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.UserTypeEnum;
import org.springframework.stereotype.Service;

@Service
public class UserValidationImpl implements IUserValidation {
    @Override
    public boolean isSeller(User user) {
        return user.getType() == UserTypeEnum.SELLER;
    }
    @Override
    public boolean isCommonUser(User user) {
        return user.getType() == UserTypeEnum.COMMON;
    }

}