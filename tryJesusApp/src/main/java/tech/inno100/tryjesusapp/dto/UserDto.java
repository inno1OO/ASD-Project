package tech.inno100.tryjesusapp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long userId;
    @Column(unique = true, nullable = false, updatable = true)
    private String username;
    @Size(min = 8, max = 16)
    private String password;
    private String status;
    private LocalDateTime updateDate;

    public UserDto(Long userId, String username, String password, String status) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.updateDate = updateDate;
    }
}
