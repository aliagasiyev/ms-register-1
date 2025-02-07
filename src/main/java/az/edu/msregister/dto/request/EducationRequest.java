package az.edu.msregister.dto.request;

import az.edu.msregister.enums.EducationLevel;
import az.edu.msregister.enums.SpecializationType;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationRequest {
    private List universities;
    private SpecializationType specialization;
    private String course;
    private EducationLevel level;
    private Double totalPayment;
    private Integer paymentMonths;
}
