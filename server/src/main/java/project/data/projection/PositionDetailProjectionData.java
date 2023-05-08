package project.data.projection;

import java.time.LocalDateTime;

public interface PositionDetailProjectionData {

    String getCompanyName();

    String getPosition();

    String getJobLevel();

    Double getRelevantExperience();

    Double getCurrentTenure();

    Double getMonthlyBaseSalary();

    String getMonthlyBonus();

    Double getTotalAnnualCompensation();

    Double getDailyAverageWorkingHours();

    Integer getOvertimeFrequency();

    Integer getLoading();

    Integer getJobSatisfaction();

    String getSupplement();

    String getMonthlyOvertime();

    LocalDateTime getTimestamp();
}
