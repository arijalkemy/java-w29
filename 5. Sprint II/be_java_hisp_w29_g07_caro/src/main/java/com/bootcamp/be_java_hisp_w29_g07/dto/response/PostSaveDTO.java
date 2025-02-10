package com.bootcamp.be_java_hisp_w29_g07.dto.response;

import com.bootcamp.be_java_hisp_w29_g07.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the information of a saved post
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostSaveDTO {
    /**
     * Message to respond
     */
    private String message;
    /**
     * Post created
     */
    private PostDTO post;
}
