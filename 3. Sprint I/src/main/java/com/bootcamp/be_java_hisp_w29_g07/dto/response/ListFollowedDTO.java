package com.bootcamp.be_java_hisp_w29_g07.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents the list of followed sellers
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListFollowedDTO {
    /**
     * The unique identifier for the user.
     */
    private Integer id;
    /**
     * The username of the user.
     */
    private String userName;
    /**
     * List of followed sellers
     */
    private List<UserDTO> followed;
}
