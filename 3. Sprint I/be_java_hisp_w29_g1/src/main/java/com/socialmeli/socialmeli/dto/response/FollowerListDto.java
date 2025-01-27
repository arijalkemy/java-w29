package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "user_name"})
public class FollowerListDto {
    @JsonProperty("user_id")
    private Integer id;

    @JsonProperty("user_name")
    private String name;

    private List<UserDto> followers;
}
