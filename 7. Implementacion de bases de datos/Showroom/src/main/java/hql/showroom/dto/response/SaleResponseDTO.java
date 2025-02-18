package hql.showroom.dto.response;

import hql.showroom.model.Sale;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SaleResponseDTO {
    private String number;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<ClothingResponseDTO> clothingList;

    public SaleResponseDTO(Sale sale) {
        this.number = sale.getNumber();
        this.date = sale.getDate();
        this.total = sale.getTotal();
        this.paymentMethod = sale.getPaymentMethod();
        this.clothingList = sale.getClothingList().stream().map(ClothingResponseDTO::new).toList();
    }
}
