package kg.megalab.employmentproject.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateEmployeeRequest {

    String firstName;
    String lastName;
    String patronymic;
    Long positionId;
    Long characteristicsId;
    Long addressId;


}
