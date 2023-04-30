package project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

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
    private PositionType positionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private PositionLevel positionLevel;

    private String positionTitle;
    private String techniques;
    private String notes;
    private LocalDate markTime;
    private int relateSeniority;
    private int currentSeniority;
    private int monthlySalary;
    private int bonusMoney;
    private int annualSalary;
    private int dailyWorkHour;
    private int workLoadSatisfaction;
    private int emotionalSatisfaction;
    private int workOvertimeSatisfaction;

}
