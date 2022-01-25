package kg.megalab.employmentproject.model.dto;


import kg.megalab.employmentproject.model.entity.Employee;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SalaryDto {

    Long id;
    Employee employee;
    BigDecimal amount;
}
