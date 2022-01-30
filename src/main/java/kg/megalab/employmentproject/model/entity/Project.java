package kg.megalab.employmentproject.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;
import sun.awt.image.ImageWatched;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;


@Data
@Entity
@Builder
@Table(name = "tb_project")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Project extends AbstractPersistable<Long> {


    @Column(name = "project_name", nullable = false)
    String projectName;

    @Column(name = "start_date")
    Date startDate;

    @Column(name = "end_date")
    Date endDate;

    @OneToMany(mappedBy = "project")
    List<EmployeesInProjects> employeesInProjects;

    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    Boolean isActive;
}
