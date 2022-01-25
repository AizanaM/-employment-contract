package kg.megalab.employmentproject.model.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.Date;
import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectDto {

    Long id;
    String projectName;
    Date startDate;
    Date endDate;
    Set<EmployeesInProjectsDto> employeesInProjectsDto;
}
