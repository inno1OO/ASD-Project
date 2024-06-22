package tech.inno100.tryjesusapp.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.inno100.tryjesusapp.model.Member;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PrayerRequestDto {
    private Long prayerRequestId;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String category;
    @Column(nullable = false)
    @NotBlank(message = "Empty-Blank-Null not allowed")
    private String reason;
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate date;
    private boolean isExecuted;
    private String level;

    // Parameterized constructor
    public PrayerRequestDto(String category, String reason, LocalDate date, boolean isExecuted, String level) {
        this.category = category;
        this.reason = reason;
        this.date = date;
        this.isExecuted = isExecuted;
        this.level = level;
    }
}
