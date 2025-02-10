package com.socialmeli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Follow {
    private User userFollower;

    private User userFollowed;
}
