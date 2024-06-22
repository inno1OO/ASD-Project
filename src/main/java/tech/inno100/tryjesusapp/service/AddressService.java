package tech.inno100.tryjesusapp.service;

import tech.inno100.tryjesusapp.dto.AddressDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<AddressDto> addAddress(Long id, AddressDto addressDto);
    Optional<AddressDto> getAddress(int id);
    Optional<AddressDto> updateAddress(int id, AddressDto addressDto);
    Optional<AddressDto> deleteAddress(int id);
    Optional <List<AddressDto>> getAllAddresses();
}
