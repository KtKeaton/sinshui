package project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "position_detail")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class PositionDetail extends BaseModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Position position;

    private String jobLevel;
    private Double relevantExperience;
    private Double currentTenure;
    private Double monthlyBaseSalary;
    private String monthlyBonus;
    private Double totalAnnualCompensation;
    private Double dailyAverageWorkingHours;
    private Integer overtimeFrequency;
    private Integer loading;
    private Integer jobSatisfaction;
    private String supplement;
    private String monthlyOvertime;
    private LocalDateTime timestamp;

}
