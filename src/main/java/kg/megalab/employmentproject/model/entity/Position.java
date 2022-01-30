package kg.megalab.employmentproject.model.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Builder
@Table(name = "tb_position")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = true)
public class Position extends AbstractPersistable<Long> {

    @Column(name = "position_title", nullable = false)
    String positionTitle;

    @Column(name = "is_active", columnDefinition = "BOOLEAN DEFAULT TRUE ")
    Boolean isActive;
}
