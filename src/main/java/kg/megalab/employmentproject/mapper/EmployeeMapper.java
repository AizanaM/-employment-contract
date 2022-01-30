package kg.megalab.employmentproject.mapper;

import kg.megalab.employmentproject.model.dto.EmployeeDto;
import kg.megalab.employmentproject.model.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee, EmployeeDto> {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
}
