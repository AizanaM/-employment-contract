package kg.megalab.employmentproject.repository;

import kg.megalab.employmentproject.model.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
