package com.bootcamp.be_java_hisp_w29_g07.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Represents the information of a followed user
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    /**
     * The unique identifier for the user.
     */
    @JsonProperty("user_id")
    private Integer userId;
    /**
     * The username of the user.
     */
    @JsonProperty("user_name")
    private String userName;


}
