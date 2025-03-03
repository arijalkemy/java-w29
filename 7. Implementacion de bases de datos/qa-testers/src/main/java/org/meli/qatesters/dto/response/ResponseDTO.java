package org.meli.qatesters.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private T data;
    private String message;
    private Boolean success;

    public ResponseDTO(T data, String message) {
        this.data = data;
        this.message = message;
        this.success = true;
    }
}
