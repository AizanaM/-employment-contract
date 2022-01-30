package kg.megalab.employmentproject.service;

import kg.megalab.employmentproject.model.dto.EmployeeDto;
import kg.megalab.employmentproject.model.request.CreateEmployeeRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

    EmployeeDto create (CreateEmployeeRequest request);
    EmployeeDto update (EmployeeDto employeeDto);
    EmployeeDto find (Long id);
    EmployeeDto delete(Long id);
}
