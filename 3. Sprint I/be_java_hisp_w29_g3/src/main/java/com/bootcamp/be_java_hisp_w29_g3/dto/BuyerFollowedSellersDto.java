package com.bootcamp.be_java_hisp_w29_g3.dto;

import com.bootcamp.be_java_hisp_w29_g3.dto.response.SellerFollowDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyerFollowedSellersDto {
    private Integer user_id;
    private String user_name;
    private List<SellerFollowDto> followed;
}
