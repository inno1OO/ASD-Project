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
@Table(name = "member_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true, nullable = false, updatable = true)
    private String username;
    @Size(min = 8, max = 16)
    private String password;
    private String status;
//    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
//    @Column(name = "update_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDateTime updateDate;

    @OneToOne(mappedBy = "primaryUser",  fetch = FetchType.LAZY)
    private Member member;



    // Parameterized constructor
    public User(String username, String password, String status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }
}
