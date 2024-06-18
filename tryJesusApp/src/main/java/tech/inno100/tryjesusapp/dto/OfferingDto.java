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
public class OfferingDto {
    private String reason;
    private Double amount;
    private String currency;
    private String account;
    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate date;

    // Parameterized constructor
    public OfferingDto(String reason, Double amount, String currency, String account, LocalDate date) {
        this.reason = reason;
        this.amount = amount;
        this.currency = currency;
        this.account = account;
        this.date = date;
    }

}
