package tech.inno100.tryjesusapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "testimony")
public class Testimony {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testimonyId;
    private String domain;
    private String details;
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
    private Member member;

    // Parameterized constructor
    public Testimony(String domain, String details, LocalDate date) {
        this.domain = domain;
        this.details = details;
        this.date = date;
    }
}
