package kg.megalab.employmentproject.model.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Builder
@Table(name = "tb_salary")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Salary extends AbstractPersistable<Long> {

    @Column(name = "amount", columnDefinition = "BOOLEAN DEFAULT 0")
    BigDecimal amount;

    @Column(name = "start_date", nullable = false)
    LocalDate startDate;

    @ColumnDefault("'2999-12-31'")
    @Column(name = "end_date", nullable = false)
    LocalDate endDate;

    @Column(name = "is_active", nullable = false, columnDefinition = "BOOLEAN DEFAULT TRUE")
    Boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    Employee employee;




}
