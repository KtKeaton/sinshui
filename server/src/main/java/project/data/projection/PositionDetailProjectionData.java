package project.data.projection;

import java.time.LocalDate;

public interface PositionDetailProjectionData {
    String getCompanyName();
    String getPositionType();
    String getPositionLevel();
    String getPositionTitle();
    String getTechniques();
    String getNotes();
    LocalDate getMarkTime();
    Integer getRelateSeniority();
    Integer getCurrentSeniority();
    Integer getMonthlySalary();
    Integer getBonusMoney();
    Integer getAnnualSalary();
    Integer getDailyWorkHour();
    Integer getWorkLoadSatisfaction();
    Integer getEmotionalSatisfaction();
    Integer getWorkOvertimeSatisfaction();
}
