package com.meli.socialmeli.dto;

import com.meli.socialmeli.constants.ValidationValues;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSellerDto {
    private Integer user_id;

    @NotBlank
    @Size(max = ValidationValues.NAME_MAX_LENGTH_NUMBER, message = ValidationValues.NAME_MAX_LENGTH)
    private String user_name;

}
