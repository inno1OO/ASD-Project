package tech.inno100.tryjesusapp.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.inno100.tryjesusapp.model.Member;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {
    private String name;
    private LocalDate date;
    private String link;
    private LocalDateTime start;
    private LocalDateTime endTime;
    private String description;
    private String cover;
    private String platform;
    private String recordedLink;
    private String eventCategory;


    // Parameterized constructor
    public EventDto(String name, LocalDate date, String link, LocalDateTime start, LocalDateTime endTime,
                 String description, String cover, String platform, String recordedLink, String eventCategory) {
        this.name = name;
        this.date = date;
        this.link = link;
        this.start = start;
        this.endTime = endTime;
        this.description = description;
        this.cover = cover;
        this.platform = platform;
        this.recordedLink = recordedLink;
        this.eventCategory = eventCategory;
    }
}
