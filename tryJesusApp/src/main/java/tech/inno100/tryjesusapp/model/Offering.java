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
@Table(name = "offering")
public class Offering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long offeringId;
    private String reason;
    private Double amount;
    private String currency;
    private String account;
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idd")
    private Member member;

    // Parameterized constructor
    public Offering(String reason, Double amount, String currency, String account, LocalDate date) {
        this.reason = reason;
        this.amount = amount;
        this.currency = currency;
        this.account = account;
        this.date = date;
    }
}
