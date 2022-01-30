package kg.megalab.employmentproject.service.impl;

import kg.megalab.employmentproject.mapper.PositionMapper;
import kg.megalab.employmentproject.mapper.ProjectMapper;
import kg.megalab.employmentproject.model.dto.ProjectDto;
import kg.megalab.employmentproject.model.entity.Project;
import kg.megalab.employmentproject.model.request.CreateProjectRequest;
import kg.megalab.employmentproject.repository.ProjectRepository;
import kg.megalab.employmentproject.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;


    @Override
    public ProjectDto create(CreateProjectRequest request) {

        Project project = Project.builder()
                .projectName(request.getProjectName())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isActive(true)
                .build();
        projectRepository.save(project);
        return ProjectMapper.INSTANCE.toDto(project);
    }

    @Override
    public ProjectDto update(ProjectDto projectDto) {
        Project projectEntity = projectRepository.findById(projectDto.getId()).map(project -> {
            project.setProjectName(projectDto.getProjectName());
            project.setStartDate(projectDto.getStartDate());
            project.setEndDate(projectDto.getEndDate());
            return projectRepository.save(project);
        }).orElseThrow(()-> new RuntimeException("Project with id=" + projectDto.getId() + " not found"));
        return ProjectMapper.INSTANCE.toDto(projectEntity);
    }

    @Override
    public ProjectDto find(Long id) {
        return ProjectMapper.INSTANCE.toDto
                (projectRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Project with id=" + id + " not found")));

    }

    @Override
    public ProjectDto delete(Long id) {
        return ProjectMapper.INSTANCE.toDto(projectRepository.findById(id).map(project -> {
            project.setIsActive(false);
            return projectRepository.save(project);
        }).orElseThrow(()-> new RuntimeException("This position not found or already deleted")));

    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }
}
