package project.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

@Data
@Builder
@Schema(description = "request data")
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class PositionDetailCreateRequestData {

    @NotEmpty(message = "company type cannot be empty")
    private String companyType;

    @NotEmpty(message = "company name cannot be empty")
    private String companyName;

    @NotEmpty(message = "position cannot be empty")
    private String position;

    @NotEmpty(message = "job level cannot be empty")
    private String jobLevel;

    @Min(value = 0, message = "relevant experience must be greater or equal to 0")
    @NotNull(message = "relevant experience cannot be null")
    private Double relevantExperience;

    @Min(value = 0, message = "current tenure must be greater or equal to 0")
    @NotNull(message = "current tenure cannot be null")
    private Double currentTenure;

    @Min(value = 0, message = "monthly base salary must be greater or equal to 0")
    @NotNull(message = "monthly base salary cannot be null")
    private Double monthlyBaseSalary;

    @NotNull(message = "monthly bonus cannot be null")
    private String monthlyBonus;

    @Min(value = 0, message = "total annual compensation must be greater or equal to 0")
    @NotNull(message = "total annual compensation cannot be null")
    private Double totalAnnualCompensation;

    @Min(value = 0, message = "daily average working hours must be greater or equal to 0")
    @NotNull(message = "daily average working hours cannot be null")
    private Double dailyAverageWorkingHours;

    @Range(min = 1, max = 5, message = "overtime frequency must be between 1 and 5")
    @NotNull(message = "overtime frequency cannot be null")
    private Integer overtimeFrequency;

    @Range(min = 1, max = 5, message = "loading must be between 1 and 5")
    @NotNull(message = "loading cannot be null")
    private Integer loading;

    @Range(min = 1, max = 5, message = "job satisfaction must be between 1 and 5")
    @NotNull(message = "job satisfaction cannot be null")
    private Integer jobSatisfaction;

    private String supplement;

    @NotNull(message = "monthly overtime cannot be null")
    private String monthlyOvertime;

    @NotNull(message = "timestamp cannot be null")
    private String timestamp;

}
