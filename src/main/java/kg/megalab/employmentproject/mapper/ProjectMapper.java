package kg.megalab.employmentproject.mapper;

import kg.megalab.employmentproject.model.dto.ProjectDto;
import kg.megalab.employmentproject.model.entity.Project;
import org.mapstruct.factory.Mappers;

public interface ProjectMapper extends BaseMapper<Project, ProjectDto> {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

}
