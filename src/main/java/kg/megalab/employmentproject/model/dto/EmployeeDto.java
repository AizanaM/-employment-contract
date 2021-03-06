package kg.megalab.employmentproject.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;


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
    CharacteristicsDto characteristics;
    AddressDto address;
    Boolean isActive;


}
