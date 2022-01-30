package kg.megalab.employmentproject.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_characteristics")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Characteristics extends AbstractPersistable<Long> {

    @ElementCollection
    @Column(name = "hard_skills", nullable = false)
    List<String> hardSkills;

    @ElementCollection
    @Column(name = "soft_skills", nullable = false)
    List<String> softSkills;

}
