package meli.consecionario.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



public class AddVehicleDto {
    String message;
    Integer id;

    public AddVehicleDto(String message, Integer id) {
        this.message = message;
        this.id = id;
    }

    public AddVehicleDto() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
