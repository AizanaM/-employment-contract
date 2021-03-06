package kg.megalab.employmentproject.model.dto;


import kg.megalab.employmentproject.model.entity.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaryDto {

    Long id;
    Employee employee;
    BigDecimal amount;
    LocalDate startDate;
    LocalDate endDate;
    Boolean isActive;
}
