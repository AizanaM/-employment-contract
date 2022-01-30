package kg.megalab.employmentproject.repository;

import kg.megalab.employmentproject.model.entity.EmployeesInProjects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesInProjectsRepository extends JpaRepository<EmployeesInProjects, Long> {
}
