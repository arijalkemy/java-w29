package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    @Setter
    @NotNull(message = "El id no puede estar vacío")
    @JsonProperty("user_id")
    private Integer userId;

    @NotBlank(message = "Debe incluir un nombre")
    @Size(max = 15)
    @JsonProperty("user_name")
    private String userName;

    public UserDto() {
    }

    public UserDto(Integer userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}
