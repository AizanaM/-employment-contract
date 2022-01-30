package kg.megalab.employmentproject.mapper;

import kg.megalab.employmentproject.model.dto.CharacteristicsDto;
import kg.megalab.employmentproject.model.entity.Characteristics;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CharacteristicsMapper extends BaseMapper<Characteristics, CharacteristicsDto> {

    CharacteristicsMapper INSTANCE = Mappers.getMapper(CharacteristicsMapper.class);
}
