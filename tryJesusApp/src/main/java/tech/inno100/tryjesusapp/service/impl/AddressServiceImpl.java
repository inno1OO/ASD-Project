package tech.inno100.tryjesusapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import tech.inno100.tryjesusapp.dto.AddressDto;
import tech.inno100.tryjesusapp.dto.MemberDto;
import tech.inno100.tryjesusapp.model.Address;
import tech.inno100.tryjesusapp.model.Member;
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
        Optional<Address> found = addressRepository.findById(id);
        if (found.isPresent()) {
            AddressDto addressDto = modelMapper.map(found.get(), AddressDto.class);
            return Optional.of(addressDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional<AddressDto> addAddress(Long id, AddressDto addressDto) {
        return Optional.empty();
    }

    @Override
    public Optional<AddressDto> updateAddress(int id, AddressDto addressDto){
        Optional<Address> found = addressRepository.findById(id);
        if (found.isPresent()) {
            modelMapper.map(addressDto, found.get());
            Address saved = addressRepository.save(found.get());
            AddressDto addressDto1 = modelMapper.map(saved, AddressDto.class);
            return Optional.of(addressDto1);
        }
        return Optional.empty();
    }

    @Override
    public Optional<AddressDto> deleteAddress(int id){
        Optional<Address> foundAddress = addressRepository.findById(id);
        if (foundAddress.isPresent()) {
            addressRepository.delete(foundAddress.get());
            AddressDto addressDto = modelMapper.map(foundAddress.get(), AddressDto.class);
            return Optional.of(addressDto);
        }
        return Optional.empty();
    }

    @Override
    public Optional <List<AddressDto>> getAllAddresses(){
        List<Address> addresses = addressRepository.findAll();
        if (addresses.isEmpty()) {
            return Optional.empty();
        }
        List<AddressDto> addressDtos = modelMapper.map(addresses, new TypeToken<List<AddressDto>>() {}.getType());
        return Optional.of(addressDtos);
    }

}
