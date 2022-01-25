package kg.megalab.employmentproject.model.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PositionDto {

    Long id;
    String positionTitle;
    Boolean isActive;
}
