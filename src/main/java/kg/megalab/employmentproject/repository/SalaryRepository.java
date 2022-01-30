package kg.megalab.employmentproject.repository;

import kg.megalab.employmentproject.model.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary,Long> {
}
