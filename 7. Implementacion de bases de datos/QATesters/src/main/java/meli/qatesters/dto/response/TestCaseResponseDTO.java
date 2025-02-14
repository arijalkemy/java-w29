package meli.qatesters.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import meli.qatesters.model.TestCase;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestCaseResponseDTO {
    String message;
    TestCase testCase;
}
