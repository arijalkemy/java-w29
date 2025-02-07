package com.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// US 0012
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostUserDTO {
    private Integer user_id;
    private String user_name;
    private List<PostsWithProductDTO> posts;

}
