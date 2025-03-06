package hql.showroom.dto.response;

import hql.showroom.model.Clothing;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClothingResponseDTO {
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;
    private Double salePrice;

    public ClothingResponseDTO(Clothing clothing) {
        this.code = clothing.getCode();
        this.name = clothing.getName();
        this.type = clothing.getType();
        this.brand = clothing.getBrand();
        this.color = clothing.getColor();
        this.size = clothing.getSize();
        this.quantity = clothing.getQuantity();
        this.salePrice = clothing.getSalePrice();
    }
}
