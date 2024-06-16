package tech.inno100.tryjesusapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.inno100.tryjesusapp.model.Member;

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
    private String password;
    private boolean isActive;

    public MemberDto(String firstName, String lastName, String email, String phoneNumber, LocalDate birthday, String status, String matrimonialStatus, String password, boolean isActive) {
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
