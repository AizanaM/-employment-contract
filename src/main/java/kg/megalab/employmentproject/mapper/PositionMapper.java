package kg.megalab.employmentproject.mapper;

import kg.megalab.employmentproject.model.dto.PositionDto;
import kg.megalab.employmentproject.model.entity.Position;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PositionMapper extends BaseMapper<Position, PositionDto> {

    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);
}
