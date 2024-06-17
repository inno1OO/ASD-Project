package tech.inno100.tryjesusapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String firstName;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String lastName;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String email;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String phoneNumber;
    private LocalDate birthday;
    private String status;
    private String matrimonialStatus;
    private String password;
    private boolean isActive;

    //ontoone with user
    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User primaryUser;

    //self
//    @OneToOne(mappedBy = "partner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Member partner;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Offering> offerings;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Event> events;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Testimony> testimonies;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrayerRequest> prayers;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Devotion> devotions;

    public Member(String firstName, String lastName, String email, String phoneNumber, LocalDate birthday, String status, String matrimonialStatus, String password, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.status = status;
        this.matrimonialStatus = matrimonialStatus;
        this.password = password;
        this.isActive = isActive;
    }
}
