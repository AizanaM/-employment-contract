package kg.megalab.employmentproject.repository;

import kg.megalab.employmentproject.model.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
