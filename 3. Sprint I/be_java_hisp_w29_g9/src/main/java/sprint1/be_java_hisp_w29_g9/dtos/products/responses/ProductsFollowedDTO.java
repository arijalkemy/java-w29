package sprint1.be_java_hisp_w29_g9.dtos.products.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ProductsFollowedDTO {
  private Integer user_id;
  private List<PostDTO> posts;
}
