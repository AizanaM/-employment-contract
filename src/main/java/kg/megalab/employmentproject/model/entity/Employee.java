package kg.megalab.employmentproject.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.*;


@Data
@Entity
@Builder
@Table(name = "tb_employee")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Employee extends AbstractPersistable<Long> {

    @Column(name = "first_name", nullable = false)
    String firstName;

    @Column(name = "last_name", nullable = false)
    String lastName;

    @Column(name = "patronymic")
    String patronymic;

    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE")
    Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    Position position;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id", nullable = false)
    Address address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "characteristics_id", referencedColumnName = "id")
    Characteristics characteristics;


}






