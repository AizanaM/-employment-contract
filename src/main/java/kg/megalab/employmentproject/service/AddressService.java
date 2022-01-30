package kg.megalab.employmentproject.service;

import kg.megalab.employmentproject.model.dto.AddressDto;
import kg.megalab.employmentproject.model.entity.Address;
import org.springframework.stereotype.Service;

@Service
public interface AddressService {

    AddressDto update (AddressDto addressDto);
    AddressDto find (Long id);
    void save(Address address);
}
