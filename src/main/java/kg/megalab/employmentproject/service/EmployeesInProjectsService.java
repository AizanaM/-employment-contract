package kg.megalab.employmentproject.service;

import kg.megalab.employmentproject.model.dto.EmployeesInProjectsDto;
import kg.megalab.employmentproject.model.request.CreateEmployeesInProjectsRequest;
import org.springframework.stereotype.Service;

@Service
public interface EmployeesInProjectsService {
    EmployeesInProjectsDto create(CreateEmployeesInProjectsRequest request);
    EmployeesInProjectsDto find(Long id);
    EmployeesInProjectsDto update(EmployeesInProjectsDto employeesInProjectsDto);
}
