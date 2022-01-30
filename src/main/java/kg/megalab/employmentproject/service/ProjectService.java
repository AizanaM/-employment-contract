package kg.megalab.employmentproject.service;


import kg.megalab.employmentproject.model.dto.ProjectDto;;
import kg.megalab.employmentproject.model.entity.Project;
import kg.megalab.employmentproject.model.request.CreateProjectRequest;
import org.springframework.stereotype.Service;


@Service
public interface ProjectService {

    ProjectDto create (CreateProjectRequest request);
    ProjectDto update (ProjectDto projectDto);
    ProjectDto find (Long id);
    ProjectDto delete(Long id);
    void save(Project project);
}
