package com.app.dto.response;

import com.app.dto.request.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//US 0006:
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostListDTO {
    private Integer user_id;
    private List<PostDTO> posts;
}
