package hql.showroom.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SaleRequestDTO {
    private String number;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Long> clothingList; // Lista de IDs de prendas
}
