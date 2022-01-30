package kg.megalab.employmentproject.service.impl;

import kg.megalab.employmentproject.mapper.EmployeeMapper;
import kg.megalab.employmentproject.mapper.EmployeesInProjectsMapper;
import kg.megalab.employmentproject.mapper.ProjectMapper;
import kg.megalab.employmentproject.model.dto.EmployeeDto;
import kg.megalab.employmentproject.model.dto.EmployeesInProjectsDto;
import kg.megalab.employmentproject.model.dto.ProjectDto;
import kg.megalab.employmentproject.model.entity.EmployeesInProjects;
import kg.megalab.employmentproject.model.request.CreateEmployeesInProjectsRequest;
import kg.megalab.employmentproject.repository.EmployeesInProjectsRepository;
import kg.megalab.employmentproject.service.EmployeeService;
import kg.megalab.employmentproject.service.EmployeesInProjectsService;
import kg.megalab.employmentproject.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeInProjectServiceImpl implements EmployeesInProjectsService {

    private final EmployeesInProjectsRepository employeesInProjectsRepository;
    public final EmployeeService employeeService;
    public final ProjectService projectService;

    @Override
    public EmployeesInProjectsDto create(CreateEmployeesInProjectsRequest request) {

        EmployeeDto employeeDto = employeeService.find(request.getEmployeeId());
        ProjectDto projectDto = projectService.find(request.getProjectId());

        EmployeesInProjects employeesInProjects = EmployeesInProjects
                .builder()
                .employee(EmployeeMapper.INSTANCE.toEntity(employeeDto))
                .project(ProjectMapper.INSTANCE.toEntity(projectDto))
                .daysInProject(request.getDaysInProject())
                .build();

            employeesInProjectsRepository.save(employeesInProjects);
            return EmployeesInProjectsMapper.INSTANCE.toDto((EmployeesInProjectsMapper) employeesInProjects);

    }

    @Override
    public EmployeesInProjectsDto find(Long id) {
        return EmployeesInProjectsMapper.INSTANCE.toDto
                ((EmployeesInProjectsMapper) employeesInProjectsRepository.findById(id)
                        .orElseThrow(()-> new RuntimeException("Employee in project by id=" + id + " not found")));
    }

    @Override
    public EmployeesInProjectsDto update(EmployeesInProjectsDto employeesInProjectsDto) {

        EmployeesInProjects employeesInProjectsEntity = employeesInProjectsRepository.findById(employeesInProjectsDto
                .getId()).map(employeesInProjects -> {
                    employeesInProjects.setProject(employeesInProjects.getProject());
                    return employeesInProjectsRepository.save(employeesInProjects);
        }).orElseThrow(()-> new RuntimeException("Not Found"));
        return EmployeesInProjectsMapper.INSTANCE.toDto((EmployeesInProjectsMapper) employeesInProjectsEntity);
    }
}
