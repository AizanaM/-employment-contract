package kg.megalab.employmentproject.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Builder
@Table(name = "tb_project")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Projects extends AbstractPersistable<Long> {


    @Column(name = "project_name", nullable = false)
    String projectName;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    @OneToMany(mappedBy = "project")
    Set<EmployeesInProjects> employeesInProjects;
}
