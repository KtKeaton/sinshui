package project.repository.projection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import project.data.projection.PositionDetailProjectionData;
import project.model.PositionDetail;

public interface PositionDetailProjectionDao extends JpaRepository<PositionDetail, Long> {

    @Query(value = """
            SELECT
                c.companyName AS companyName,
                pl.positionName AS position,
                pd.jobLevel AS jobLevel,
                pd.relevantExperience AS relevantExperience,
                pd.currentTenure AS currentTenure,
                pd.monthlyBaseSalary AS monthlyBaseSalary,
                pd.monthlyBonus AS monthlyBonus,
                pd.totalAnnualCompensation AS totalAnnualCompensation,
                pd.dailyAverageWorkingHours AS dailyAverageWorkingHours,
                pd.overtimeFrequency AS overtimeFrequency,
                pd.loading AS loading,
                pd.jobSatisfaction AS jobSatisfaction,
                pd.supplement AS supplement,
                pd.monthlyOvertime AS monthlyOvertime,
                pd.timestamp AS timestamp
            FROM PositionDetail pd
                JOIN pd.company c
                JOIN c.companyType ct
                JOIN pd.position pl
            WHERE ct.typeName = :companyType
            """)
    Page<PositionDetailProjectionData> getAllPositionDetails(@Param("companyType") String companyType,
            Pageable pageable);

    @Query(value = """
            SELECT
                c.companyName AS companyName,
                pl.positionName AS position,
                pd.jobLevel AS jobLevel,
                pd.relevantExperience AS relevantExperience,
                pd.currentTenure AS currentTenure,
                pd.monthlyBaseSalary AS monthlyBaseSalary,
                pd.monthlyBonus AS monthlyBonus,
                pd.totalAnnualCompensation AS totalAnnualCompensation,
                pd.dailyAverageWorkingHours AS dailyAverageWorkingHours,
                pd.overtimeFrequency AS overtimeFrequency,
                pd.loading AS loading,
                pd.jobSatisfaction AS jobSatisfaction,
                pd.supplement AS supplement,
                pd.monthlyOvertime AS monthlyOvertime,
                pd.timestamp AS timestamp
            FROM PositionDetail pd
                JOIN pd.company c
                JOIN c.companyType ct
                JOIN pd.position pl
            """)
    Page<PositionDetailProjectionData> getAll(Pageable pageable);
}
