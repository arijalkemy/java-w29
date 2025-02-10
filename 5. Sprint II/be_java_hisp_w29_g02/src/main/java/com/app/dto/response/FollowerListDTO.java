package com.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//US 0003 US 0008
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowerListDTO {
    private Integer user_id;
    private String user_name;
    private List<UserDTO> followers;

}
