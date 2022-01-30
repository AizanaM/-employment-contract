package kg.megalab.employmentproject.service.impl;

import kg.megalab.employmentproject.mapper.AddressMapper;
import kg.megalab.employmentproject.model.dto.AddressDto;
import kg.megalab.employmentproject.model.entity.Address;
import kg.megalab.employmentproject.model.request.CreateAddressRequest;
import kg.megalab.employmentproject.repository.AddressRepository;
import kg.megalab.employmentproject.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    //Адресс создается автоматически при создании Сотрудника

    @Override
    public AddressDto update(AddressDto addressDto) {

        Address addressEntity = addressRepository.findById(addressDto.getId()).map(address -> {
            address.setCountry(addressDto.getCountry());
            address.setCity(addressDto.getCity());
            address.setStreet(addressDto.getStreet());
            address.setHouse(addressDto.getHouse());
            address.setApartment(addressDto.getApartment());
            address.setPostcode(addressDto.getPostcode());
            return addressRepository.save(address);
        }).orElseThrow(()-> new RuntimeException("Not found"));
        return AddressMapper.INSTANCE.toDto(addressEntity);
    }

    @Override
    public AddressDto find(Long id) {
        return AddressMapper.INSTANCE.toDto
                (addressRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Address with id=" + id + " not found")));

    }


    @Override
    public void save(Address address) {
        addressRepository.save(address);

    }
}
