package sprint1.be_java_hisp_w29_g9.dtos.products.requests;

import lombok.Getter;

@Getter
public class GetFollowedProductPostsRequestDTO {
    private Integer user_id;
    private String order;
}
