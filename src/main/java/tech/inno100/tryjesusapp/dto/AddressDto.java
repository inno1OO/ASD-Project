package tech.inno100.tryjesusapp.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.inno100.tryjesusapp.model.Member;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    private Integer addressId;
    private String country;
    private String city;
    private String street;
    private boolean isCurrent;

    public AddressDto(String country, String city, String street, boolean isCurrent) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.isCurrent = isCurrent;
    }
}
