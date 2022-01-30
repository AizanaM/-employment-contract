package kg.megalab.employmentproject.model.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateCharacteristicsRequest {

    List<String> hardSkills;
    List<String> softSkills;
}
