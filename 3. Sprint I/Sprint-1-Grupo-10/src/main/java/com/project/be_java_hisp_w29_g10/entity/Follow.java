package com.project.be_java_hisp_w29_g10.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Follow {
    private Long seller_id;
    private Long user_id;
}
