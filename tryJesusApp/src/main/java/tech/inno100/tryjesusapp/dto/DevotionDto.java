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
public class DevotionDto {
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
    //    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    @Column(name = "done_date", columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private LocalDate doneDate;


    public DevotionDto(String questionOne, String questionTwo, String questionThree, String prayer, LocalDate devotionDate, LocalDate doneDate) {
        this.questionOne = questionOne;
        this.questionTwo = questionTwo;
        this.questionThree = questionThree;
        this.prayer = prayer;
        this.devotionDate = devotionDate;
        this.doneDate = doneDate;
    }
}
