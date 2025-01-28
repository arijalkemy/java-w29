package sprint1.be_java_hisp_w29_g9.dtos.users.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSellerDto {
    private int id;
    private String user_name;
    private List followers;
}
