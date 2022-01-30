package kg.megalab.employmentproject.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateSalaryRequest {

    BigDecimal amount;
    Long employeeId;
    LocalDate startDate;
    LocalDate endDate;
    Boolean isActive;
}
