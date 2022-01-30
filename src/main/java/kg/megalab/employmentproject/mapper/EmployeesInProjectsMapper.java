package kg.megalab.employmentproject.mapper;

import kg.megalab.employmentproject.model.dto.EmployeesInProjectsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeesInProjectsMapper extends BaseMapper<EmployeesInProjectsMapper, EmployeesInProjectsDto> {

    EmployeesInProjectsMapper INSTANCE = Mappers.getMapper(EmployeesInProjectsMapper.class);
}
