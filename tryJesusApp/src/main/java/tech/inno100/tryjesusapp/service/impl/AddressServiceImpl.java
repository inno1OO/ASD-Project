package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.AddressDto;
import tech.inno100.tryjesusapp.model.Address;
import tech.inno100.tryjesusapp.repository.AddressRepository;
import tech.inno100.tryjesusapp.service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<AddressDto> getAddress(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressDto> addAddress(AddressDto addressDto) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressDto> updateAddress(int id, AddressDto addressDto){
        return Optional.empty();
    }

    @Override
    public Optional<AddressDto> deleteAddress(int id){
        return Optional.empty();
    }

    @Override
    public Optional <List<AddressDto>> getAllAddresses(){
        return Optional.empty();
    }

}
