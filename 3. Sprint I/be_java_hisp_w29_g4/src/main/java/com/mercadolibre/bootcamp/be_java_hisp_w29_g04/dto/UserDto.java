package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {

    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    public UserDto() {
    }

    public UserDto(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
