package kg.megalab.employmentproject.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDto {

    Long id;
    String firstName;
    String lastName;
    String patronymic;
    PositionDto position;
    Set<EmployeesInProjectsDto> employeesInProjectsDto;
    CharacteristicsDto characteristics;
    AddressDto address;
    Boolean isActive;


}
