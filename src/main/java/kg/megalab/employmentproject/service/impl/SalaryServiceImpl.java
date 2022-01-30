package kg.megalab.employmentproject.service.impl;


import kg.megalab.employmentproject.mapper.EmployeeMapper;
import kg.megalab.employmentproject.mapper.SalaryMapper;
import kg.megalab.employmentproject.model.dto.EmployeeDto;
import kg.megalab.employmentproject.model.dto.SalaryDto;
import kg.megalab.employmentproject.model.entity.Salary;
import kg.megalab.employmentproject.model.request.CreateSalaryRequest;
import kg.megalab.employmentproject.repository.SalaryRepository;
import kg.megalab.employmentproject.service.EmployeeService;
import kg.megalab.employmentproject.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;
    private final EmployeeService employeeService;


    @Override
    public SalaryDto create(CreateSalaryRequest request) {

        EmployeeDto employeeDto = employeeService.find(request.getEmployeeId());

        Salary salary = Salary
                .builder()
                .employee(EmployeeMapper.INSTANCE.toEntity(employeeDto))
                .amount(request.getAmount())
                .startDate(request.getStartDate())
                .endDate(LocalDate.of(2999, 12, 31))
                .isActive(true)
                .build();
        salaryRepository.save(salary);
        return SalaryMapper.INSTANCE.toDto(salary);

    }

    @Override
    public SalaryDto update(SalaryDto salaryDto) {

        Salary salaryEntity = salaryRepository.findById(salaryDto.getId()).map(salary -> {
            salary.setEndDate(salaryDto.getEndDate());
            return  salaryRepository.save(salary);
        }).orElseThrow(()-> new RuntimeException("Not Found"));
        return SalaryMapper.INSTANCE.toDto(salaryEntity);
    }

    @Override
    public SalaryDto find(Long id) {
        return SalaryMapper.INSTANCE.toDto
                (salaryRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Salary with id=" + id + " not found")));
    }

    @Override
    public SalaryDto delete(Long id) {
        return SalaryMapper.INSTANCE.toDto(salaryRepository.findById(id).map(salary -> {
            salary.setIsActive(false);
            return salaryRepository.save(salary);
        }).orElseThrow(()-> new RuntimeException("This salary not found or already deleted")));
    }

    @Override
    public void save(Salary salary) {
        salaryRepository.save(salary);
    }
}
