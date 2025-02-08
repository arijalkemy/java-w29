package sprint1.be_java_hisp_w29_g9.dtos.users.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sprint1.be_java_hisp_w29_g9.entities.Seller;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFollowedResponseDTO {
    private Integer user_id;
    private String fullname;
    private List<SellerFollowersInfoDTO> followed;
}
