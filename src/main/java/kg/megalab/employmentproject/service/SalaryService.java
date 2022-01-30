package kg.megalab.employmentproject.service;

import kg.megalab.employmentproject.model.dto.SalaryDto;
import kg.megalab.employmentproject.model.entity.Salary;
import kg.megalab.employmentproject.model.request.CreateSalaryRequest;
import org.springframework.stereotype.Service;


@Service
public interface SalaryService {

    SalaryDto create (CreateSalaryRequest request);
    SalaryDto update (SalaryDto salaryDto);
    SalaryDto find (Long id);
    SalaryDto delete(Long id);
    void save(Salary salary);
}
