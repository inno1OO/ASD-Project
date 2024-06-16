package tech.inno100.tryjesusapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;
    private String country;
    private String city;
    private String street;
    private boolean isCurrent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // Parameterized constructor
    public Address(String country, String city, String street, boolean isCurrent) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.isCurrent = isCurrent;
    }
}
