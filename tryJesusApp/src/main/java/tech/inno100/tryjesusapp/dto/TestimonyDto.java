package tech.inno100.tryjesusapp.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.inno100.tryjesusapp.model.Member;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestimonyDto {
    private Long testimonyId;
    private String domain;
    private String details;
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate date;

    // Parameterized constructor
    public TestimonyDto(String domain, String details, LocalDate date) {
        this.domain = domain;
        this.details = details;
        this.date = date;
    }
}
