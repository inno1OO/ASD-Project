package tech.inno100.tryjesusapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true, nullable = false, updatable = true)
    private String username;
    @Size(min = 8, max = 16)
    private String password;
    private String status;
    private LocalDateTime updateDate;

    @OneToOne(mappedBy = "primaryUser",  fetch = FetchType.LAZY)
    private User user;



    // Parameterized constructor
    public User(String username, String password, String status, LocalDateTime updateDate) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.updateDate = updateDate;
    }
}
