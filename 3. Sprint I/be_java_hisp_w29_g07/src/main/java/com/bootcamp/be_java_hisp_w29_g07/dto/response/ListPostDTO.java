package com.bootcamp.be_java_hisp_w29_g07.dto.response;

import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a seller's list of posts
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListPostDTO {
    /**
     * The unique identifier for the user.
     */
    private Integer user_id;
    /**
     * List of post publishes by a seller
     */
    private List<PostDTO> posts;
}
