package project.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.time.LocalDate;

@Data
@Builder
@Schema(description = "request data")
public class PositionDetailCreateRequestData {

    @NotEmpty(message = "company name cannot be empty")
    private String companyName;

    @NotEmpty(message = "position type cannot be empty")
    private String positionType;

    @NotEmpty(message = "position level cannot be empty")
    private String positionLevel;

    @NotEmpty(message = "position title cannot be empty")
    private String positionTitle;

    @Schema(nullable = true)
    private String techniques;

    @Schema(nullable = true)
    private String notes;

    @NotNull(message = "mark time cannot be null")
    private LocalDate markTime;

    @Min(value = 0, message = "relate seniority must be greater or equal to 0")
    @NotNull(message = "relateSeniority cannot be null")
    private Integer relateSeniority;

    @Min(value = 0, message = "current seniority must be greater or equal to 0")
    @NotNull(message = "currentSeniority cannot be null")
    private Integer currentSeniority;

    @Min(value = 0, message = "monthly salary must be greater or equal to 0")
    @NotNull(message = "monthlySalary cannot be null")
    private Integer monthlySalary;

    @Min(value = 0, message = "bonus money must be greater or equal to 0")
    @NotNull(message = "bonusMoney cannot be null")
    private Integer bonusMoney;

    @Min(value = 0, message = "annual salary must be greater or equal to 0")
    @NotNull(message = "annualSalary cannot be null")
    private Integer annualSalary;

    @Min(value = 0, message = "daily work hour must be greater or equal to 0")
    @NotNull(message = "dailyWorkHour cannot be null")
    private Integer dailyWorkHour;

    @Range(min = 1, max = 5, message
            = "work load satisfaction must be between 1 and 5")
    @NotNull(message = "workLoadSatisfaction cannot be null")
    private Integer workLoadSatisfaction;

    @Range(min = 1, max = 5, message
            = "emotional satisfaction must be between 1 and 5")
    @NotNull(message = "emotionalSatisfaction cannot be null")
    private Integer emotionalSatisfaction;

    @Range(min = 1, max = 5, message
            = "work over time satisfaction must be between 1 and 5")
    @NotNull(message = "workOvertimeSatisfaction cannot be null")
    private Integer workOvertimeSatisfaction;
}
