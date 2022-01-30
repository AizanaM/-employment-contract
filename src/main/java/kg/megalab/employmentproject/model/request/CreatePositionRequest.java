package kg.megalab.employmentproject.model.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreatePositionRequest {

    String positionTitle;
    //Boolean isActive;
}
