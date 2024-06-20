package tech.inno100.tryjesusapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.inno100.tryjesusapp.dto.AddressDto;
import tech.inno100.tryjesusapp.service.AddressService;
import tech.inno100.tryjesusapp.service.MemberService;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressService addressService;

    @PostMapping("/member/{id}")
    public ResponseEntity<AddressDto> addAddress(@PathVariable Long id, @RequestBody AddressDto addressDto){
        Optional<AddressDto> address = addressService.addAddress(id, addressDto);
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<AddressDto> getAddress(@PathVariable int id){
        Optional<AddressDto> address = addressService.getAddress(id);
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable("id") int id, @RequestBody AddressDto addressDto){
        Optional<AddressDto> address = addressService.updateAddress(id, addressDto);
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("address/{id}")
    public ResponseEntity<AddressDto> deleteAddress(@PathVariable int id){
        Optional<AddressDto> address = addressService.deleteAddress(id);
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<AddressDto>> getAllAddresses(){
        Optional <List<AddressDto>> address = addressService.getAllAddresses();
        if(address.isPresent()){
            return ResponseEntity.ok(address.get());
        }
        return ResponseEntity.notFound().build();
    }
}
