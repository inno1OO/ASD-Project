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
@Table(name = "prayer_request")
public class PrayerRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prayerRequestId;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String category;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String reason;
    private LocalDate date;
    private boolean isExecuted;
    private String level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // Parameterized constructor
    public PrayerRequest(String category, String reason, LocalDate date, boolean isExecuted, String level) {
        this.category = category;
        this.reason = reason;
        this.date = date;
        this.isExecuted = isExecuted;
        this.level = level;
    }
}
