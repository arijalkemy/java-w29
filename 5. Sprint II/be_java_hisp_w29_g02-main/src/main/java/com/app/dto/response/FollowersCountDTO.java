package com.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// US 0002
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersCountDTO {
    private Integer user_id;
    private String user_name;
    private Integer followers_count;
}
