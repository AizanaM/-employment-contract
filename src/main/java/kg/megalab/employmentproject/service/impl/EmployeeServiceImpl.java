package kg.megalab.employmentproject.service.impl;


import kg.megalab.employmentproject.mapper.EmployeeMapper;
import kg.megalab.employmentproject.mapper.PositionMapper;
import kg.megalab.employmentproject.model.dto.EmployeeDto;
import kg.megalab.employmentproject.model.dto.PositionDto;
import kg.megalab.employmentproject.model.entity.Address;
import kg.megalab.employmentproject.model.entity.Characteristics;
import kg.megalab.employmentproject.model.entity.Employee;
import kg.megalab.employmentproject.model.request.CreateEmployeeRequest;
import kg.megalab.employmentproject.repository.EmployeeRepository;
import kg.megalab.employmentproject.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    public final EmployeeRepository employeeRepository;
    public final CharacteristicsService characteristicsService;
    public final AddressService addressService;
    public final PositionService positionService;



    @Override
    public EmployeeDto create(CreateEmployeeRequest request) {


        PositionDto positionDto = positionService.find(request.getPositionId());

        Address address = Address.builder()
                .country("N/A")
                .city("N/A")
                .street("N/A")
                .house("N/A")
                .build();
        addressService.save(address);

        Characteristics characteristics = Characteristics.builder()
                .hardSkills(new ArrayList<String>())
                .softSkills(new ArrayList<String>())
                .build();
        characteristicsService.save(characteristics);



        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .patronymic(request.getPatronymic())
                .isActive(true)
                .address(address)
                .characteristics(characteristics)
                .position(PositionMapper.INSTANCE.toEntity(positionDto))
                .build();

        employeeRepository.save(employee);
        EmployeeDto employeeDto = EmployeeMapper.INSTANCE.toDto(employee);
        return employeeDto;
    }

    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {

        Employee employeeEntity = employeeRepository.findById(employeeDto.getId()).map(employee -> {
            employee.setLastName(employeeDto.getLastName());
            employee.setPosition(PositionMapper.INSTANCE.toEntity(employeeDto.getPosition()));
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Not Found"));
        return EmployeeMapper.INSTANCE.toDto(employeeEntity);
    }

    @Override
    public EmployeeDto find(Long id) {
        Employee employee = employeeRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Employee with id" + id + "is not found"));
        return EmployeeMapper.INSTANCE.toDto(employee);
    }

    @Override
    public EmployeeDto delete(Long id) {
        return EmployeeMapper.INSTANCE.toDto(employeeRepository.findById(id).map(employee -> {
            employee.setIsActive(false);
            return employeeRepository.save(employee);
        }).orElseThrow(() -> new RuntimeException("Employee not found or already deleted")));
    }
}
