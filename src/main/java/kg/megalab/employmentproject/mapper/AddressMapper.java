package kg.megalab.employmentproject.mapper;

import kg.megalab.employmentproject.model.dto.AddressDto;
import kg.megalab.employmentproject.model.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public interface AddressMapper extends BaseMapper<Address, AddressDto> {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
}
