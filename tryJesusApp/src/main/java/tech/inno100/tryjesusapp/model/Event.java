package tech.inno100.tryjesusapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;
    private String name;
    private LocalDate date;
    private String link;
    private LocalDateTime start;
    private LocalDateTime end;
    private String description;
    private String cover;
    private String platform;
    private String recordedLink;
    private String eventCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    // Parameterized constructor
    public Event(String name, LocalDate date, String link, LocalDateTime start, LocalDateTime end,
                 String description, String cover, String platform, String recordedLink, String eventCategory) {
        this.name = name;
        this.date = date;
        this.link = link;
        this.start = start;
        this.end = end;
        this.description = description;
        this.cover = cover;
        this.platform = platform;
        this.recordedLink = recordedLink;
        this.eventCategory = eventCategory;
    }
}
