package project.repository.projection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import project.data.projection.PositionDetailProjectionData;
import project.model.PositionDetail;

public interface PositionDetailProjectionDao extends JpaRepository<PositionDetail, Long> {

    @Query(value = "SELECT " +
            "pd.annualSalary AS annualSalary, " +
            "c.companyName AS companyName, " +
            "pt.positionTypeName AS positionType, " +
            "pl.positionLevelName AS positionLevel, " +
            "pd.positionTitle AS positionTitle, " +
            "pd.techniques AS techniques, " +
            "pd.notes AS notes, " +
            "pd.markTime AS markTime, " +
            "pd.relateSeniority AS relateSeniority, " +
            "pd.currentSeniority AS currentSeniority, " +
            "pd.monthlySalary AS monthlySalary, " +
            "pd.bonusMoney AS bonusMoney, " +
            "pd.dailyWorkHour AS dailyWorkHour, " +
            "pd.workLoadSatisfaction AS workLoadSatisfaction, " +
            "pd.emotionalSatisfaction AS emotionalSatisfaction, " +
            "pd.workOvertimeSatisfaction AS workOvertimeSatisfaction " +
            "FROM PositionDetail pd " +
            "JOIN pd.company c " +
            "JOIN pd.positionLevel pl " +
            "JOIN pd.positionType pt")
    Page<PositionDetailProjectionData> getAllPositionDetails(Pageable pageable);
}
