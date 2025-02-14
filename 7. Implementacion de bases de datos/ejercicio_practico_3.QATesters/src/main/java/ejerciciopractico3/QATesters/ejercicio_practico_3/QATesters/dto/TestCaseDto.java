package ejerciciopractico3.QATesters.ejercicio_practico_3.QATesters.dto;

import lombok.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class TestCaseDto {
    private Long idCase;
    private String description;
    private Boolean tested;
    private Boolean passed;
    private int numberOfTries;
    private Date lastUpdate;

}
