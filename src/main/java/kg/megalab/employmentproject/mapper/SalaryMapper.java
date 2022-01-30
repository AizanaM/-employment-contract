package kg.megalab.employmentproject.mapper;

import kg.megalab.employmentproject.model.dto.SalaryDto;
import kg.megalab.employmentproject.model.entity.Salary;
import org.mapstruct.factory.Mappers;

public interface SalaryMapper extends BaseMapper<Salary, SalaryDto> {

    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);
}
