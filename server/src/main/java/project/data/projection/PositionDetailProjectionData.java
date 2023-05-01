package project.data.projection;

import java.time.LocalDateTime;

public interface PositionDetailProjectionData {

    String getCompanyName();

    String getPosition();

    String getJobLevel();

    String getRelevantExperience();

    String getCurrentTenure();

    String getMonthlyBaseSalary();

    String getMonthlyBonus();

    String getTotalAnnualCompensation();

    String getDailyAverageWorkingHours();

    Integer getOvertimeFrequency();

    Integer getLoading();

    Integer getJobSatisfaction();

    String getSupplement();

    String getMonthlyOvertime();

    LocalDateTime getTimestamp();
}
