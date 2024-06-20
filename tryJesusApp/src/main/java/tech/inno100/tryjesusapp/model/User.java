package tech.inno100.tryjesusapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "member_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(unique = true, nullable = false, updatable = true)
    private String username;
//    @Size(min = 8, max = 16)
    private String password;
    private String status;
//    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
//    @Column(name = "update_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDateTime updateDate;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "user",  fetch = FetchType.LAZY)
    private Member member;

    // Parameterized constructor
    public User(String username, String password, String status, Role role) {
        this.username = username;
        this.password = password;
        this.status = status;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getSimpleGrantedAuthority();
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_"+role.name()));
//        return authorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
