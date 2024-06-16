package tech.inno100.tryjesusapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "member")
public class Devotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long devotionId;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String questionOne;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String questionTwo;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String questionThree;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String prayer;
    private LocalDate devotionDate;
    private LocalDate doneDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Devotion(String questionOne, String questionTwo, String questionThree, String prayer, LocalDate devotionDate, LocalDate doneDate) {
        this.devotionId = devotionId;
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
        this.prayer = prayer;
        this.devotionDate = devotionDate;
        this.doneDate = doneDate;
    }
}
