package sprint1.be_java_hisp_w29_g9.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Seller {
    private Integer id;
    private List<Post> posts;
    private String user_name;
}
