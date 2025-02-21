package ejercicios_extra_p1.dtos;

import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

import ejercicios_extra_p1.entities.Dress;
import ejercicios_extra_p1.entities.Sale;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SaleDto {
  private LocalDate date;
  private Double total;
  private String payment_method;
  private Set<DressDto> dresses;

  public SaleDto(Sale sale) {
    this.date = sale.getDate();
    this.total = sale.getTotal();
    this.payment_method = sale.getPayment_method();
    this.dresses = sale.getDresses().stream().map(DressDto::new).collect(Collectors.toSet());
  }

  public Sale toSale() {
    return new Sale(
      null,
      this.date,
      this.total,
      this.payment_method,
      this.dresses.stream().map(DressDto::toDress).collect(Collectors.toSet())
    );
  }
}
