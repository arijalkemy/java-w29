package com.example.showroom.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class SaleDetailKey implements Serializable {
    private Sale sale;

    private Clothe clothe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SaleDetailKey that)) return false;
        return sale.equals(that.sale) && clothe.equals(that.clothe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sale, clothe);
    }
}
