package tech.inno100.tryjesusapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.inno100.tryjesusapp.model.Member;
import tech.inno100.tryjesusapp.model.User;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
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
    private boolean isActive;
//    private String userName;
//    private String password;
//    private String role;
    private User user;


    public MemberDto(String firstName, String lastName, String email, String phoneNumber, LocalDate birthday, String status, String matrimonialStatus, boolean isActive) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.status = status;
        this.matrimonialStatus = matrimonialStatus;
        this.isActive = isActive;

    }
}
