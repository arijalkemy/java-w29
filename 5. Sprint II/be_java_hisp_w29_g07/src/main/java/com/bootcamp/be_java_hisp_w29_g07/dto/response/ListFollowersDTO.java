package com.bootcamp.be_java_hisp_w29_g07.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents the list of followers of a user.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFollowersDTO {
    /**
     * The unique identifier for the user.
     */
    private Integer user_id;
    /**
     * The username of the user.
     */
    private String user_name;
    /**
     * List of followed sellers
     */
    private List<UserDTO> followers;

}
