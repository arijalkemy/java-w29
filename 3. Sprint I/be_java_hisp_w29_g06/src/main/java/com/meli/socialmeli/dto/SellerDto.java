package com.meli.socialmeli.dto;

import com.meli.socialmeli.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto {
    private Integer user_id;
    private String user_name;
    private Integer followers_count;
}