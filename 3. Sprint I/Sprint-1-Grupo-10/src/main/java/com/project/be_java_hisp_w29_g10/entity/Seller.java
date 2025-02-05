package com.project.be_java_hisp_w29_g10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Seller {
    private Long id_seller;
    private String user_name;
    private String phone_number;
}
