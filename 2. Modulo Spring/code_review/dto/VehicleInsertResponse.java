package org.example.code_review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class VehicleInsertResponse implements Serializable {
    private List<VehicleDto> vehicles;
    private int insertedCount;

    @Override
    public String toString() {
        return "VehicleInsertResponse{" +
                "vehicles=" + vehicles +
                ", insertedCount=" + insertedCount +
                '}';
    }
}
