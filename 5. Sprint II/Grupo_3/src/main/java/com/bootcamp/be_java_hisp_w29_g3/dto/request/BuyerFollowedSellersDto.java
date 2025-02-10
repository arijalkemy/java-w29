package com.bootcamp.be_java_hisp_w29_g3.dto.request;

import com.bootcamp.be_java_hisp_w29_g3.dto.response.SellerFollowDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BuyerFollowedSellersDto {
    private Integer user_id;

    @NotEmpty(message = "El nombre de usuario no puede estar vació")
    @Size(max = 15, message = "El nombre de usuario no púede tener mas de 15 caracteres")
    private String user_name;

    @NotNull(message = "La lista de Vendedores no puede ser nula")
    @NotEmpty(message = "La lista de Vendedores no puede estar vaciá")
    private List<@Valid SellerFollowDto> followed;
}
