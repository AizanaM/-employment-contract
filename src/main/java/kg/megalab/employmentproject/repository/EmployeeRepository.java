package kg.megalab.employmentproject.repository;

import kg.megalab.employmentproject.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
